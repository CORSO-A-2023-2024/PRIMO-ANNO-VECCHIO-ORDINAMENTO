.globl _start
.data 
	size: .word  8 
	array: .byte 4, 3, -2, 7, 8, 12, 15
	result: .word 0
 
.text

_start:
	la t5, array # load the vector address
	la t4, size # load the size address
	lb t0, 0(t4) # load the actual size
	li t2, 0 # final sum
loop:
	lb t1, 0(t5) # first element of the vector
	andi t3, t3, 1
	beq t3, zero, max
	addi t2, t2, 1
max: 
	addi t5, t5, 4 # move to the next word in the array
	addi t0, t0, -1 # decrement the counter controlling the number of elements to be checked
	bne t0, zero, loop # if not done, jump
save:
	la t3 result
	sb t2, 0(t3)
	



exit:
    addi x17, x0, 10  # call number 10 = exit
    ecall