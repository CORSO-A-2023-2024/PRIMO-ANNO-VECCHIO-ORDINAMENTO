# strcmp
.globl _start

.data
      str1: .string "first"
      str2: .string "second"

.text
_start:

      # call strcmp
      la   a0, str1
      la   a1, str2
      jal  ra, strcmp

      # result in a0
      li    a7, 1
      ecall
exit:
      #call number 10 = exit
      li    a7, 10
      ecall

################################################################################
# a0 = const char *str1
# a1 = const char *str2
################################################################################
strcmp:
# qui vi tocca scrivere








      
      
 ret     
      

################################################################################

