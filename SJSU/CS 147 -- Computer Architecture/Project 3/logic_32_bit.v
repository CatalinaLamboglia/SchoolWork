// Name: logic_32_bit.v
// Module: 
// Input: 
// Output: 
//
// Notes: Common definitions
// 
//
// Revision History:
//
// Version	Date		Who		email			note
//------------------------------------------------------------------------------------------
//  1.0     Sep 02, 2014	Kaushik Patra	kpatra@sjsu.edu		Initial creation
//------------------------------------------------------------------------------------------
//

// 32-bit NOR
module NOR32_2x1(Y,A,B);
//output 
output [31:0] Y;
//input
input [31:0] A;
input [31:0] B;

// TBD
nor nor0(Y[0], A[0], B[0]);
nor nor1(Y[1], A[1], B[1]);
nor nor2(Y[2], A[2], B[2]);
nor nor3(Y[3], A[3], B[3]);
nor nor4(Y[4], A[4], B[4]);
nor nor5(Y[5], A[5], B[5]);
nor nor6(Y[6], A[6], B[6]);
nor nor7(Y[7], A[7], B[7]);
nor nor8(Y[8], A[8], B[8]);
nor nor9(Y[9], A[9], B[9]);
nor nor10(Y[10], A[10], B[10]);
nor nor11(Y[11], A[11], B[11]);
nor nor12(Y[12], A[12], B[12]);
nor nor13(Y[13], A[13], B[13]);
nor nor14(Y[14], A[14], B[14]);
nor nor15(Y[15], A[15], B[15]);
nor nor16(Y[16], A[16], B[16]);
nor nor17(Y[17], A[17], B[17]);
nor nor18(Y[18], A[18], B[18]);
nor nor19(Y[19], A[19], B[19]);
nor nor20(Y[20], A[20], B[20]);
nor nor21(Y[21], A[21], B[21]);
nor nor22(Y[22], A[22], B[22]);
nor nor23(Y[23], A[23], B[23]);
nor nor24(Y[24], A[24], B[24]);
nor nor25(Y[25], A[25], B[25]);
nor nor26(Y[26], A[26], B[26]);
nor nor27(Y[27], A[27], B[27]);
nor nor28(Y[28], A[28], B[28]);
nor nor29(Y[29], A[29], B[29]);
nor nor30(Y[30], A[30], B[30]);
nor nor31(Y[31], A[31], B[31]);

endmodule

// 32-bit AND
module AND32_2x1(Y,A,B);
//output 
output [31:0] Y;
//input
input [31:0] A;
input [31:0] B;

// TBD

and and0(Y[0], A[0], B[0]);
and and1(Y[1], A[1], B[1]);
and and2(Y[2], A[2], B[2]);
and and3(Y[3], A[3], B[3]);
and and4(Y[4], A[4], B[4]);
and and5(Y[5], A[5], B[5]);
and and6(Y[6], A[6], B[6]);
and and7(Y[7], A[7], B[7]);
and and8(Y[8], A[8], B[8]);
and and9(Y[9], A[9], B[9]);
and and10(Y[10], A[10], B[10]);
and and11(Y[11], A[11], B[11]);
and and12(Y[12], A[12], B[12]);
and and13(Y[13], A[13], B[13]);
and and14(Y[14], A[14], B[14]);
and and15(Y[15], A[15], B[15]);
and and16(Y[16], A[16], B[16]);
and and17(Y[17], A[17], B[17]);
and and18(Y[18], A[18], B[18]);
and and19(Y[19], A[19], B[19]);
and and20(Y[20], A[20], B[20]);
and and21(Y[21], A[21], B[21]);
and and22(Y[22], A[22], B[22]);
and and23(Y[23], A[23], B[23]);
and and24(Y[24], A[24], B[24]);
and and25(Y[25], A[25], B[25]);
and and26(Y[26], A[26], B[26]);
and and27(Y[27], A[27], B[27]);
and and28(Y[28], A[28], B[28]);
and and29(Y[29], A[29], B[29]);
and and30(Y[30], A[30], B[30]);
and and31(Y[31], A[31], B[31]);

endmodule

// 32-bit inverter
module INV32_1x1(Y,A);
//output 
output [31:0] Y;
//input
input [31:0] A;

// TBD
assign Y = ~A;

endmodule

// 32-bit OR
module OR32_2x1(Y,A,B);
//output 
output [31:0] Y;
//input
input [31:0] A;
input [31:0] B;

wire [31:0] tempY;

NOR32_2x1 nor_inst(.Y(tempY),.A(A),.B(B));
INV32_1x1 inv(.Y(Y), .A(tempY));

endmodule
