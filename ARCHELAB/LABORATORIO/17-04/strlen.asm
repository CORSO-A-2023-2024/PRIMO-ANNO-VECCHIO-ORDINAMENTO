.globl _start

.data 
string1: .string "ciao!"
string2: .string "ok"

.text

_start:
	la a0, string1
	la a1, string2
  	jal ra, strlen

print:
    mv a0, s1
    li a7, 1
    ecall

exit:
    li a7, 10
    ecall

strlen:
	lbu t0, 0(a0)
	bne t0, zero, for
	jr ra

for:
	addi a0, a0, 1
	addi t1, t1,1 
	j strlen