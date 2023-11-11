# Invert an array in memory using swap
.globl _start

.data
      size:   .word 16
      array:  .word 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15

.text
_start:
      la    s1, size

      la    a0, array 
      lw    a1, 0(s1)
      jal   ra, print

      la    a0, array #indirizzo base per v
      lw    a1, 0(s1) #v.length
      jal   ra, invert

      la    a0, array
      lw    a1, 0(s1)
      jal   ra, print

exit:
      li    a7, 10 #call number 10 = exit
      ecall

################################################################################
# Procedure swap(v, x, y)
# a0  -> address of v
# a1 -> index x
# a2 -> index y
# does not return anything
# swap is a leaf procedure that can be implemented with only temp registers
################################################################################
swap:
      addi sp, sp, -8
      sd t0, 0(sp)
      slli  a1, a1, 2     # calculates offset of x 
      slli  a2, a2, 2     # calculates offset of y
      add   t0, a0, a1    # address of v[x]
      add   t1, a0, a2    # address of v[y]

      lw    t2, 0(t0)     #v[x]
      lw    t3, 0(t1)	  #v[y]
      sw    t3, 0(t0)     #mette il valore di v[y] in posizione x
      sw    t2, 0(t1)     #mette il valore di v[x] in posizione y
      ld t0, 0(sp)
      addi sp, sp, 8
      ret                 # return


################################################################################
# Procedure invert(v)
# a0 -> v address
# a1 -> v size
################################################################################
invert:
	addi sp, sp, -32
	sd ra, 0(sp) #salvo il return address
	sd a0, 8(sp) #salvo l'indirizzo base
	sd s1, 16(sp) #salvo size
	sd s2, 24(sp) #salvo per convenzione di chiamata
      	addi  s1, zero, 0         # index of first element
      addi  s2, a1, -1          # indice ultimo elemento (size-1)
LOOP_invert:
      blt   s2, s1, END_invert  # if s2 < s1 goto end

      ld    a0, 8(sp) #carico in a0 l'indirizzo base
      add   a1, s1, zero #carico in a1 l'indirizzo della prima estremità
      add   a2, s2, zero #carico in a2 l'indirizzo della seconda estremità
      jal   ra, swap #chiamo swap(a0, a1, a2)
      addi  s1, s1, 1 
      addi  s2, s2, -1
      j     LOOP_invert
END_invert:

      ld    ra, 0(sp)           # restore the return address
      ld    s1, 16(sp)
      ld    s2, 24(sp)
      addi  sp, sp, 32          # restore the stack pointer

      ret

################################################################################
# Procedure print(v)
# a0 -> v address
# a1 -> v size
################################################################################
print:
      addi  sp, sp, -32
      sd    s1, 0(sp)
      sd    a0, 8(sp)
      sd    a1, 16(sp)
      sd    ra, 24(sp)

      li    s1, 0               # index
LOOP_print:
      beq   s1, a1, EXIT_print

      slli  t1, s1, 2           # calculates offset in the array
      add   t1, t1, a0          # t1 has the address of the element
      lw    t0, 0(t1)           # t0 has the number to print

      addi  a0, t0, 0           # print a number
      li    a7, 1
      ecall

      addi  a0, zero, 0x20      # print space
      li    a7, 11
      ecall

      ld    a0, 8(sp)           # recover the value of a0
      ld    a1, 16(sp)          # recover the value of a1
      addi  s1, s1, 1           # move to the next word
      j     LOOP_print
EXIT_print:

      addi  a0, zero, 0x0A      # print new line
      li    a7, 11
      ecall

      ld    s1, 0(sp)
      ld    ra, 24(sp)
      addi  sp, sp, 32
      ret
################################################################################
