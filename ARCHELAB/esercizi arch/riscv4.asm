.globl _start

.data 
string1: .string "ciao!"

.text

_start:
	la a0, string1
  	jal ra, strlen

# print size, ret in a0
li a7, 1
ecall

exit:
    li a7, 10
    ecall
    
strlen:
	lbu t0, 0(a0)
	addi t1, t1, 1
	addi a0, a0, 1
	bnez t0, strlen
strlen_end: 
	mv a0, t1
	ret