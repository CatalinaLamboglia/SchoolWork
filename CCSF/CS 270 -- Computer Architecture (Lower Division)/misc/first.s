#
# first.s - a first simple MIPS assembler program
#

# first, we use the .data directive to tell the assembler that the 
# data section is next.  we set up some data with labels a1, b1, c1,
# x, y, and result with some initial values.  they are all words,
# i.e. 32-bit signed values
    .data
a1: .word   -2
b1: .word   10
c1: .word   16
x:  .word   0x12345678
y:  .word   0x9abcdef0
result: .word   0

# now, determine what MIPS instructions you need to compute the 
# following algorithm: result = a1+b1+c1
#
# put your instructions after the .text directive.  unlike the simple
# machine, you don't need a halt instruction at the end, it'll stop 
# at the end of the file.
    .text
lw $t0, a1
lw $t1, b1
lw $t2, c1
add $s1, $t0, $t1
add $s1, $s1, $t2
sw $s1, result
