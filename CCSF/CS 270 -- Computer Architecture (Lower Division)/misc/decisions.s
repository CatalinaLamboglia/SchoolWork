#
# this is the starting file our exercise on decisions.
# It must be run with the exception handler enabled 
# (in Mars, use Settings->Exception Handler and 
# navigate to the file exceptions.s) 
#
    .data
max:  .word 100
min:  .word -100
Nelems: .word 16
num: .word -100
arr:    .word 10,-321,42,-4,168,-2,46,9,102,-56,-100,16,-43,0,99,-101
arrend:	# DO NOT MOVE THIS LABEL
nlmsg:  .asciiz     "\n"
arrstartmsg: .asciiz "Here is the array at program start:\n"
arrendmsg: .asciiz "Here is the array at program end:\n"
resultmsg: .asciiz  "Here is result:"
    .text
    .globl main
main:
    ### STARTARR
    # this section of code outputs a message, then the contents
    # of the array
    li  $v0,4
    la  $a0,arrstartmsg
    syscall
    la  $t0,arr
    la  $t1,arrend
Larrstartloop:
    bge $t0,$t1,Larrstartend
    lw  $a0,0($t0)
    li  $v0,1
    syscall
    la  $a0,nlmsg
    li  $v0,4
    syscall
    add $t0,$t0,4
    b   Larrstartloop
Larrstartend:
    ### END STARTARR
    # end of the starting 'output the array' section
    #
    #
    #  Ugly C code with gotos and labels for our algorithm:
    #  result = 0;
    #  i = Nelems-1;
    #
    #  Loop:
    #  if (i==0) goto Exit;
    #  if (arr[i]>=0) goto Decrement; // if arr[i] is positive, we don't change it.  go to end of loop.
    #  arr[i] = -arr[i];              // if arr[i] is negative, flip to positive, and increment result
    #  result++;
    #  
    #  Decrement:
    #  i--;
    #  goto Loop;
    #
    #  Exit:
    #
    # your code goes here.
    # result must be in $t7 when you finish!
    #
    addi $t7, $zero,0    #results = 0
    lw $s0, Nelems       #i = numElems
    subi $s0, $s0, 1     #i--
    la $t0, arr          #addr of array
    Loop:
    sll $t1, $s0, 2      #t1 = i*4
    add $t1, $t1, $t0    #t1 = t1 + addr of array
    lw $t2, ($t1)        #arr[i]
    beq $s0, $zero, Exit #if(i==0)Exit;
    bgez $t2, Decrement  #if(arr[i]>=0)Decrement
    sub $t3, $zero, $t2  #make val of arr[i] negative
    sw  $t3, ($t1)       #save pos value
    addi $t7, $t7, 1     #result++
    Decrement:
    subi $s0, $s0, 1     #i--
    j Loop
    Exit:
Endarr:
    ### ENDARR
    # this section of code outputs a message, then the contents
    # of the array, then the value of result ($t7)
    li  $v0,4
    la  $a0,arrendmsg
    syscall
    la  $t0,arr
    la  $t1,arrend
Larrendloop:
    bge $t0,$t1,Larrendend
    lw  $a0,0($t0)
    li  $v0,1
    syscall
    la  $a0,nlmsg
    li  $v0,4
    syscall
    add $t0,$t0,4
    b   Larrendloop
Larrendend:
    li  $v0,4
    la  $a0,resultmsg
    syscall
    li  $v0,1
    move $a0,$t7
    syscall
    ### END STARTARR
    # end of the ending 'output the array' section
    #
    # last, return
    jr  $ra
