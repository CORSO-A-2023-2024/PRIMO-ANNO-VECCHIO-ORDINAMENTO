.globl _start
.data
    buffer: .string  "test string"
    low:    .byte  'A'
    high:   .byte  'Z'

.text
_start:
    # call contains
    la   a0, buffer
    la   a1, low
    la   a2, high
    lbu  a1, 0(a1)
    lbu  a2, 0(a2)
    jal  ra, contains

    # exit
    li   a7, 10
    ecall

#******************************************
# completare la funzione nel campo di sotto
contains:
	addi sp, sp, -24
	sd ra, 0(sp)
	sd a0, 8(sp)
	sd fp, 16(sp)
	addi fp, sp, 16

WHILE:	
	lbu t0, 0(a0)
	beqz t0, FINE
	blt t0, a1, END_WHILE
	bge t0, a2, END_WHILE
	addi t1, zero, 1
	jr ra

END_WHILE:
	addi a0, a0, 1
	mv t1, zero
	jal contains
FINE: 	
	mv a0, t1
	ld fp, 16(sp)
	ld ra, 0(sp)
	addi sp, sp, 24
	jr ra
