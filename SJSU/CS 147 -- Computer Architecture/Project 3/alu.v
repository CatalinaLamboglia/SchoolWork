// Name: alu.v
// Module: ALU
// Input: OP1[32] - operand 1
//        OP2[32] - operand 2
//        OPRN[6] - operation code
// Output: OUT[32] - output result for the operation
//
// Notes: 32 bit combinatorial ALU
// 
// Supports the following functions
//	- Integer add (0x1), sub(0x2), mul(0x3)
//	- Integer shift_rigth (0x4), shift_left (0x5)
//	- Bitwise and (0x6), or (0x7), nor (0x8)
//  - set less than (0x9)
//
// Revision History:
//
// Version	Date		Who		email			note
//------------------------------------------------------------------------------------------
//  1.0     Sep 10, 2014	Kaushik Patra	kpatra@sjsu.edu		Initial creation
//------------------------------------------------------------------------------------------
//
`include "prj_definition.v"
module ALU(OUT, ZERO, OP1, OP2, OPRN);
// input list
input [`DATA_INDEX_LIMIT:0] OP1; // operand 1
input [`DATA_INDEX_LIMIT:0] OP2; // operand 2
input [`ALU_OPRN_INDEX_LIMIT:0] OPRN; // operation code

// output list
output [`DATA_INDEX_LIMIT:0] OUT; // result of the operation.
output ZERO;

wire [31:0] nor_res;
wire [31:0] or_res;
wire [31:0] and_res;
wire [31:0] add_sub_res;
wire [31:0] shifter_res;
wire [31:0] mul_res;
wire [31:0] mul_high;
wire [31:0] add_sub_2;
wire CO;

wire [31:0] n; //place holder, n for nothing

//making SnA
wire one_bit_and_res;
wire inv_res;
wire SnA;

wire nor_res_0;
wire nor_res_1;
wire nor_res_2;
wire nor_res_3;
wire nor_res_4;
wire nor_res_5;
wire nor_res_6;
wire nor_res_7;
wire nor_res_8;
wire nor_res_9;
wire nor_res_10;
wire nor_res_11;
wire nor_res_12;
wire nor_res_13;
wire nor_res_14;
wire nor_res_15;
wire nor_res_16;
wire nor_res_17;
wire nor_res_18;
wire nor_res_19;
wire nor_res_20;
wire nor_res_21;
wire nor_res_22;
wire nor_res_23;
wire nor_res_24;
wire nor_res_25;
wire nor_res_26;
wire nor_res_27;
wire nor_res_28;
wire nor_res_29;
wire nor_res_30;

and and_1(one_bit_and_res, OPRN[3], OPRN[0]);
assign inv_res = ~OPRN[0];
or or_1(SnA, one_bit_and_res, inv_res);


MULT32 mult(.HI(mul_high), .LO(mul_res), .A(OP1), .B(OP2));
SHIFT32 shifter(.Y(shifter_res), .D(OP1), .S(OP2), .LnR(OPRN[0]));
RC_ADD_SUB_32 add_sub(.Y(add_sub_res), .CO(CO), .A(OP1), .B(OP2), .SnA(SnA));

NOR32_2x1 nor_inst(.Y(nor_res), .A(OP1), .B(OP2));
AND32_2x1 and_inst(.Y(and_res), .A(OP1), .B(OP2));
OR32_2x1  or_inst(.Y(or_res), .A(OP1), .B(OP2));

assign add_sub_2 = {{31{1'b0}},add_sub_res[31]};

MUX32_16x1 mux(.Y(OUT), .I0(n), .I1(add_sub_res), .I2(add_sub_res), .I3(mul_res), .I4(shifter_res), .I5(shifter_res),
               .I6(and_res), .I7(or_res), .I8(nor_res), .I9(add_sub_2), .I10(n), .I11(n),
               .I12(n), .I13(n), .I14(n), .I15(n), .S(OPRN[3:0]));

//NOR32_2x1 nor_1(.Y(ZERO), .A(OUT), .B(OUT));
//nor nor_1(nor_res_1, nor_res_0, OUT[2]);
//entire lower block was nors before
or nor0(nor_res_0, OUT[0], OUT[1]);
or nor1(nor_res_1, nor_res_0, OUT[2]);
or nor2(nor_res_2, nor_res_1, OUT[3]);
or nor3(nor_res_3, nor_res_2, OUT[4]);
or nor4(nor_res_4, nor_res_3, OUT[5]);
or nor5(nor_res_5, nor_res_4, OUT[6]);
or nor6(nor_res_6, nor_res_5, OUT[7]);
or nor7(nor_res_7, nor_res_6, OUT[8]);
or nor8(nor_res_8, nor_res_7, OUT[9]);
or nor9(nor_res_9, nor_res_8, OUT[10]);
or nor10(nor_res_10, nor_res_9, OUT[11]);
or nor11(nor_res_11, nor_res_10, OUT[12]);
or nor12(nor_res_12, nor_res_11, OUT[13]);
or nor13(nor_res_13, nor_res_12, OUT[14]);
or nor14(nor_res_14, nor_res_13, OUT[15]);
or nor15(nor_res_15, nor_res_14, OUT[16]);
or nor16(nor_res_16, nor_res_15, OUT[17]);
or nor17(nor_res_17, nor_res_16, OUT[18]);
or nor18(nor_res_18, nor_res_17, OUT[19]);
or nor19(nor_res_19, nor_res_18, OUT[20]);
or nor20(nor_res_20, nor_res_19, OUT[21]);
or nor21(nor_res_21, nor_res_20, OUT[22]);
or nor22(nor_res_22, nor_res_21, OUT[23]);
or nor23(nor_res_23, nor_res_22, OUT[24]);
or nor24(nor_res_24, nor_res_23, OUT[25]);
or nor25(nor_res_25, nor_res_24, OUT[26]);
or nor26(nor_res_26, nor_res_25, OUT[27]);
or nor27(nor_res_27, nor_res_26, OUT[28]);
or nor28(nor_res_28, nor_res_27, OUT[29]);
or nor29(nor_res_29, nor_res_28, OUT[30]);
or nor30(nor_res_30, nor_res_29, OUT[31]);

assign ZERO = ~nor_res_30; // just not the result bit
endmodule
