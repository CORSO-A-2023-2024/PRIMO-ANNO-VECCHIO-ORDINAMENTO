.globl _start
.data 

 
.text

_start:

	li t0, -10
	li t1, 280
	li t2, 39

	add t3, t0, zero
	
	blt t1, t3, else1
	add t3, t1, zero
	
else1:	
	blt t2, t3, else2 
	add t3, t2, zero
else2:
	
   

exit:
    addi x17, x0, 10  # call number 10 = exit
    ecall