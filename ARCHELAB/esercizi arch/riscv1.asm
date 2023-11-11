.globl _start
.data
    num1: .dword 24
    num2: .dword 30
.text
_start:
    # call MCD
    la    a0, num1
    la    a1, num2
    ld    a0, 0(a0)
    ld    a1, 0(a1)     
    jal   ra, mcm

    #exit
    li    a7, 10
    ecall

#****************************************************
# completare la funzione MCD nel campo di sotto

mcd:
	addi sp, sp, -32
	sd ra, 8(sp)
	sd a0, 16(sp)
	sd a1, 24(sp)
	sd fp, 0(sp)
	addi fp, sp, 24
	
	bne a1, zero, WHILE
	j FINE
SWAP:
	mv t0, a1
	mv a1, a0
	mv a0, t0
	j WHILE	

WHILE:
	bge a1, a0, SWAP
	mv t0, a1
	rem a1, a0, a1
	mv a0, t0
	jal mcd
FINE:
	ld ra, 8(sp)
	ld a1, 24(sp)
	ld fp, 0(sp)
	addi sp, sp, 32
	jr ra
	
mcm:
	addi sp, sp, -24
	sd fp, 0 (sp)
	sd ra, 8(sp)
	sd a0, 16(sp)
	addi fp, sp, 8
	jal ra, mcd
	mv t0, a0
	ld a0, 16(sp)
	mul a0, a0, a1
	div a0, a0, t0
	ld fp, 0(sp)
	ld ra, 8(sp)
	jr ra