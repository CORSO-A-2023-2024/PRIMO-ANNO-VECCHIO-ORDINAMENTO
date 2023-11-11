.globl _start
.data 
	v1: .word -2 
	v2: .word -4
	v3: .word -8
	v4: .word -11
 
.text

_start:

	la t0, v1 # base address of our .data segment
	lw t1, 0(t0) # copy the first word to t1
	lw t2, 4(t0) # copy the second word to t2
	lw t3, 8(t0)
	lw t4, 12(t0)
	add t1, t1, t2 # sum the words and save it on register t3
	add t1, t1, t3
	add t1, t1, t4
	srai t1, t1, 2  
	sw t1, 16(t0)


exit:
    addi x17, x0, 10  # call number 10 = exit
    ecall