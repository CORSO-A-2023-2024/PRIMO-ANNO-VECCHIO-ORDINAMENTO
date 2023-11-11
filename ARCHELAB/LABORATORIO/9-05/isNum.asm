# ########################################################################
# Scrivere una funzione RISC-V isnumber che controlla se una stringa ricevuta
# come parametro è la rappresentazione di un numero intero positivo in ASCII.
# Controllare vuol dire: restituire 1 se la condizione è vera, 0 altrimenti.
# 
# isnumber deve utilizzare la funzione isdigit realizzata nell'esercizio
# precedente.
# ########################################################################


.globl _start

.data
  in_str: .string "123" 

.text

_start:
  la a0, in_str

  jal isnumber
  
  li a7, 1 # stampo risultato {0,1}
  ecall

exit:
  li a7, 10
  ecall


# ######################################################################## int
# isnumber(char* in_str){
#   char* cursor = in_str;
#
#   if(!(*cursor)){return 0;}
#
#   while(*cursor){
#     if(!isdigit(*cursor)){
#       return 0;
#     }
#     ++cursor;
#   }
#   return 1;
# }
# 

isnumber:
	addi sp, sp, -16
	sd ra, 0(sp) #mi salvo ra
	sd s0, 8(sp) #mi salvo l'indirizzo della stringa
	mv s0, a0

loop: 
	lbu t3, 0(s0) #carico il contenuto di un carattere della stringa
	beqz t3, fine 
	mv a0, t3 #metto il carattere in a0
	jal isdigit
	
	beqz a0, fine
	addi s0, s0, 1
	j loop

fine:
	ld ra, 0(sp)
	ld s0, 8(sp)
	addi sp,sp,8
	ret



# =================================
# int isdigit(char in_char) {
#   return (in_char >= 48 && in_char <= 57) ? 1 : 0;
# }
# =================================
# a0 --> in_char
# 

isdigit: 
	li t1, 48
  	li t2, 57
	bge a0, t1, end1
	li a0, 0
	ret
end1:  ble a0, t2, retVal
	li a0, 0
	ret
retVal: li a0, 1
	ret
  

















