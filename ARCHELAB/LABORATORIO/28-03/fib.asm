.globl _start
.data 

 
.text

_start:

	li t0, 8 #N
	li t3, 1 #B
	
ciclo:
	add t3, t2, t3
	sub t2, t3, t2
	addi t0, t0, -1

 bne t0, zero, ciclo 

exit:
    addi x17, x0, 10  # call number 10 = exit
    ecall