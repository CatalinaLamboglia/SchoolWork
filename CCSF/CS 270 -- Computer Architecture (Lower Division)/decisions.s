#
# this is the starting file for each of the programming
# problems in Lab-Decisions. It must be run with the exception
# handler added (in Mars, use Settings->Exception Handler. 
#    Navigate to the file exceptions.s in /usr/local/lib )
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
    # Check: $t0 has address of arr in it
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
    la $t0, arr		          # put array's base address in $t0
    lw $t2, Nelems            # we will use $t2 for our counter i.  first, put Nelems in it.
    addi $t2, $t2, -1         # we actually want Nelems-1 for i, so subtract 1 from it.
    add $t7, $zero, $zero     # $t7 stores result.  set it to zero
    
Loop:
    beq $t2, $zero, Endarr    # if i==0, we are done with the loop
    
    # calculate address of arr[i]
    sll $t3, $t2, 2           # calculate i*4 and store in $t3
    add $t3, $t3, $t0         # $t0 has array's base address.  after this instruction, $t3 has address of arr[i]

    lw $t4, 0($t3)            # put arr[i]'s value in $t4 
    bge $t4, $zero, Decrement # if it's non-negative, don't change it, so skip over the next part where we change negatives.
    
    # if we get here, we know it's negative.
    # first change arr[i] to -arr[i] and store result.  remember $t3 has address of arr[i]
    sub $t4, $zero, $t4
    sw  $t4, 0($t3)
    
    # now, increment $t7, result
    addi $t7, $t7, 1          
        
Decrement:
    addi $t2, $t2, -1          # decrement counter and go back to loop top
    j Loop
    
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

