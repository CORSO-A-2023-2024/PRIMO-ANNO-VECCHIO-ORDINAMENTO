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
        
        
       
        
         
          
           
            
             
               
fine:
        ret
        
       
