# #############################################################################
# Esercizio 6 – minarray
# 
# Scrivere una funzione minarray(v, s) che restituisca l’indice del valore
# minimo presente nell’array v.
# 
# Nota: L'indirizzo di v deve essere passato come parametro a minarray insieme a
# s (size), che rappresenta il numero di word in v.
# #############################################################################

.globl _start

.data
  size:   .word 5
  array:  .word 3, 2, 0, 1, 7


.text
_start:
  la a0, array      # load the vector address
  la a1, size       # load the size address
  lw a1, 0(a1)      # load the actual size

  jal minarray

  li a7, 1
  ecall

exit:
  li a7, 10
  ecall

# int minarray(int* array, int size){
#   int min_idx = 0;
#   int min_val = array[0];
#   int i = 1;
#
#   while(i < size){
#     if(array[i] < min_val){
#       min_idx = i;
#       min_val = array[i];
#     }
#     ++i;
#   }
#   return min_idx;
# }
# #############################################################################
# a0 --> indirizzo del vettore
# a1 --> val della size
# #############################################################################
minarray:
  	mv t0, a0
  	li t3, 1 #indice
  	li t4, 0 #indice del minimo
  	lw t1, 0(t0) #metto il primo numero
  	
loop:
	addi t0, t0, 4
	lw t2, 0(t0) #metto il numero in pos i
	beq t3, a1, fine
	j calc
calc:
	ble t1, t2, avanti
	mv t1, t2
	mv t4, t3
avanti:
	addi t3, t3, 1
	j loop	





fine:
	mv a0, t4
	ret



