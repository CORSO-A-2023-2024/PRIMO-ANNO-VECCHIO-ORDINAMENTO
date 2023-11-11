.globl _start

.text

_start:
  	li a0, 24  # a
  	li a1, 30  # b
  	li s1, 0  # result

  	jal mcm
  	add s1, a0, zero

print:
    mv a0, s1
    li a7, 1
    ecall

exit:
    li a7, 10
    ecall

mcm: 
	addi sp, sp, -8
	mul t0, a0, a1
	sd ra, 0(sp)
	jal mcd
	div a0, t0, a0
	ld ra, 0(sp)
	addi sp, sp, 8
	jr ra
mcd:
    bne a0, a1, whileloop
    jr ra

whileloop:
	bge a0, a1, else
	sub a1, a1, a0
	j mcd
else:
	sub a0, a0, a1
	j mcd