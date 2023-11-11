.globl _start
.data 

 
.text

_start:

	li t1, 10 #N iterazioni ciclo
	li t2, 0 #addendo 1

ciclo:
	mul t3, t1, t1
	
	add t2, t2, t3
	addi t1, t1, -1
	bne t1, zero, ciclo
	
stampa: 
	mv a0, t2
	li a7, 1
	ecall

exit:
    addi x17, x0, 10  # call number 10 = exit
    ecall