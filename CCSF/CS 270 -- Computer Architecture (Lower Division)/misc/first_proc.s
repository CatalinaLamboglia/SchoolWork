# this file is the starting point for the function we looked at in class:
#
# int leaf_example(int g, int h, int i, int j)
# {
#  int f;
#  f = (g+h) - (i+j);
#  return f;
# }
#
# in this first procedure program, we are not going to use the stack.


    .data
# here are some numbers that get passed as arguments to leaf_example()
nums:   .word  5,2,3,1
message: .asciiz "leaf_example() returned:"

    .text
    .globl main
main:
    # this is some code to save $ra.  don't worry about this code and 
    # don't change it.
    addiu $sp, $sp, -20
    sw $ra, 16($sp)

    # 1.  set up arguments
    #
    # you need to copy arguments to argument registers $a0-$a3
    # hint: load the base address of nums to a register using la,
    # then use lw with offsets to put nums[0] in $a0, 
    # nums[1] in $a1, etc. 
    # PUT CODE TO DO THIS HERE:
    la $t0, nums
    lw $a0, 0($t0)
    lw $a1, 4($t0)
    lw $a2, 8($t0)
    lw $a3, 12($t0)
    # 2.  call your function
    # 
    # use jal to jump and link to your function (at label leaf_example)
    # PUT CODE TO DO THIS HERE:
    jal leaf_example

    # After your function returns (using jr $ra) it will come here.
    # I've put some code here which will output the result to a message
    # dialog, using the MessageDialogInt in util.s.  Don't change this.
    la      $a0,message
    move    $a1,$v0
    jal     MessageDialogInt
    lw      $ra, 16($sp)
    addiu   $sp, $sp, 20  
    jr      $ra

    
    
    # int leaf_example(int g, int h, int i, int j)
    # {
    #  int f;
    #  f = (g+h) - (i+j);
    #  return f;
    # }
    .globl leaf_example
leaf_example:

    # 3. function's algorithm
    # - the arguments are in $a0, $a1, $a2, $a3
    # - use $s0 for local variable f, which stores the result. 
    # PUT CODE TO DO THIS HERE:
    add $s0, $a0, $a1
    sub $s0, $s0, $a2
    sub $s0, $s0, $a3
    # 4. set up return value and return
    # now that $s0 has f, we need to put it in $v0 to return, and
    # then call jr $ra to return.
    # PUT CODE TO DO THIS HERE:
    move $v0, $s0
    jr $ra

# if you are on your laptop, you need to copy this file to somewhere local and
# update this path:
.include "/pub/cs/mluttrel/cs270/util.s"


