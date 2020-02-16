# this file is the stub for the add6() function for 
# part one of Exercise B - MIPS procedures
#  you are to add a function add6. the prototype and
#  algorithm are below

    .data
# nums is an array storing the numbers that we will pass to add6()
nums:   .word  1,2,3,4,5,6
message: .asciiz "add6 returned:"
    .text
    .globl main
main:
    # need room for 6 arguments and $ra; 7 words = 28 bytes
    addiu   $sp,$sp,-28
    # save $ra
    sw      $ra,24($sp)
    # load the base address of nums in $t0, and then 
    # load all 6 nums to their correct spot for 
    # procedure call to add6
    la      $t0,nums
    lw      $a0,0($t0)   # first 4 nums go to $a0-$a3
    lw      $a1,4($t0)
    lw      $a2,8($t0)
    lw      $a3,12($t0)
    lw      $t1,16($t0)  # arg4 (fifth argument) goes on stack
    sw      $t1,16($sp)  # place on stack #arg4 at 16($sp)
    lw      $t1,20($t0)
    sw      $t1,20($sp)  # arg5
    jal     add6
    la      $a0,message
    move    $a1,$v0
    jal     MessageDialogInt
    lw      $ra,24($sp)
    addiu   $sp,$sp,28
    jr      $ra

#
# add6 - function to add its six commandline arguments and return
# the result:
#  int add6(int a, int b, int c, int d, int e, int f) {
#      return(a+b+c+d+e+f);
#  }
    .globl add6
add6:
    add $v0, $a0, $a1
    add $v0, $v0, $a2
    add $v0, $v0, $a3
    lw  $t0, 16($sp)  #load arg4
    add $v0, $v0, $t0 #add arg4
    lw  $t0, 20($sp)  #load arg5
    add $v0, $v0, $t0 #add arg5
    jr      $ra

.include "/pub/cs/mluttrel/cs270/util.s"


