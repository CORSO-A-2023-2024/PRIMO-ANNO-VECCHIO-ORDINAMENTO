# Compute n-th element of Fibonacci
.globl _start

.data
    
.text
_start:
        # valore di prova
        addi a0,zero,8
        
        # call procedure
        jal ra,fib

        # print result already in a0
        li    a7, 1
        ecall

exit:
        li    a7, 10 # call number 10 = exit
        ecall

################################################################################
# Procedure fib(n) - Recursive Fibonacci 
# a0 -> element to compute: note fib(0) = 0, fib(1) = 1
################################################################################
fib: 
	beqz a0, fine
	addi t0, zero, 1
	beq a0, t0, fine
	
	addi sp, sp, -16
	sd ra, 0(sp) #
	sd a0, 8(sp) #n
	
	addi a0, a0, -1
	jal fib
	ld t0, 8(sp)
	sd a0, 8(sp)
	addi a0, t0, -2
	jal fib
	
	ld, t0, 8(sp)
	add a0, a0, t0
	ld ra, 0(sp)
	addi sp, sp, 16        
        
       
        
         
          
           
            
             
               
fine:
        ret
        
       
