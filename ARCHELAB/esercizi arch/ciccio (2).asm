.globl _start

.data
      src: .string "source"
      dst: .string "-------------"

.text
_start:

      # print the size of src
      la   a0, src
      jal  ra, strlen
      li   a7, 1
      ecall

      # print new line
      addi a0, zero, 0x0A
      li   a7, 11
      ecall

      # print the size of dst
      la   a0, dst
      jal  ra, strlen
      li   a7, 1
      ecall

      # print new line
      addi a0, zero, 0x0A
      li   a7, 11
      ecall

      # call strcpy
      la   a0, src
      la   a1, dst
      jal  ra, strcpy

      # print the size of dst
      la   a0, dst
      jal  ra, strlen
      li   a7, 1
      ecall

exit:
      #call number 10 = exit
      li    a7, 10
      ecall

################################################################################
# a0 = const char *str
################################################################################
strlen:
	addi sp, sp, -8
	sd t0, 0(sp)
	add fp, sp, zero
loop_strlen:
	lbu t0, 0(a0)
	beqz t0, fine_strlen
	addi t1, t1, 1
	addi a0, a0, 1
	j loop_strlen

fine_strlen:
	mv a0, t1
	add t1, zero, zero
	ld t0, 0(sp)
	sub fp, fp, sp
	addi sp, sp, 8
	ret
	
################################################################################
# a0 = const char *str
# a1 = const char *dst
################################################################################
strcpy:
	addi sp, sp, -40
	sd ra, 0(sp)
	sd a0, 8(sp)
	sd a1, 16(sp)
	sd t0, 24(sp)
	sd t1, 32(sp)
	addi fp, sp, 32
	
	add a0, a0, zero
	jal ra, strlen
	mv t0, a0 #metto in t0 str.length
	add a0, a1, zero
	jal ra strlen
	mv t1, a0 #metto in t1 dst.length
	
	ld a0, 8(sp) #prologo loop, metto in a0 l'indirizzo di str
	add t2, zero, zero #prologo loop, inizializzo i = 0
for_loop1: #i = a0 + t1
	beq t2, t0, for_loop2 #condizione per uscire dal ciclo for
	lbu t3, 0(a0) #carico in t2, str[i]
	sb t3, 0(a1)
	addi t2, t2, 1
	addi a0, a0, 1
	addi a1, a1, 1
	j for_loop1

for_loop2:
	beq t2, t1, fine
	sb zero, 0(a1)
	addi t2, t2, 1
	addi a1, a1, 1
	j for_loop2

 fine:
	ld ra, 0(sp)
	ld a0, 8(sp)
	ld a1, 16(sp)
	ld t0, 24(sp)
	ld t1, 32(sp)
	addi sp, sp, 40
	ret
	
	
	