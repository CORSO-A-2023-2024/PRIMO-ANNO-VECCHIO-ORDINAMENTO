.globl _start
.data 

 
.text

_start:

	li t0, 37 #numero che analizziamo
	li t1, 64 #contatore
	
ciclo:
	andi t3, t0, 1
	srli t0, t0, 1
	add t4, t4, t3 
	addi t1, t1, -1
bne t1, zero, ciclo

exit:
    addi x17, x0, 10  # call number 10 = exit
    ecall