.globl _start
.data
      buffer: .string  "BADPass"
.text
_start:
    # call passrules
    la   a0, buffer
    jal  ra, passrules

    #exit
    li   a7, 10
    ecall

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
	j FINE

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
	
#****************************************************
# completare la funzione passrules nel campo di sotto
passrules:
	addi sp, sp, -24
	sd ra, 8(sp)
	sd a0, 16(sp)
	sd fp, 0(sp)
	addi fp, sp, 16
	
	addi a1, zero, 65
	addi a2, zero, 90
	
	jal ra, contains
	mv t3, a0
	addi a1, zero, 48
	addi a2, zero, 57
	ld a0, 16(sp)
	jal ra, contains
	and a0, a0, t3
	
	ld ra, 8(sp)
	ld fp, 0(sp)
	addi sp, sp, 24
	jr ra