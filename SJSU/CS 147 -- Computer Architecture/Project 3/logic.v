// Name: logic.v
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
// 64-bit two's complement
module TWOSCOMP64(Y,A);
//output list
output [63:0] Y;
//input list
input [63:0] A;

// TBD
wire [63:0] notA;
wire [63:0] B = 64'b1;
wire SnA = 1'b0;
wire CO;
assign notA = ~A;

RC_ADD_SUB_32 fa_inst_1(.Y(Y[31:0]), .CO(CO), .A(notA[31:0]), .B(B[31:0]), .SnA(SnA));
RC_ADD_SUB_32 fa_inst_2(.Y(Y[63:32]), .CO(CO), .A(notA[63:32]), .B(B[63:32]), .SnA(SnA));
endmodule

// 32-bit two's complement
module TWOSCOMP32(Y,A);
//output list
output [31:0] Y;
//input list
input [31:0] A;

// TBD
wire [31:0] notA;
wire [31:0] B = 32'b1;
wire SnA = 1'b0;
wire CO;
assign notA = ~A;

RC_ADD_SUB_32 fa_inst_1(.Y(Y), .CO(CO), .A(notA), .B(B), .SnA(SnA));

endmodule

// 32-bit registere +ve edge, Reset on RESET=0
module REG32(Q, D, LOAD, CLK, RESET);
output [31:0] Q;

input CLK, LOAD;
input [31:0] D;
input RESET;

// TBD
wire one;
wire [31:0] Qbar;
assign one = 1'b1;
//module REG1(Q, Qbar, D, L, C, nP, nR);
REG1 reg0(.Q(Q[0]), .Qbar(Qbar[0]), .D(D[0]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg1(.Q(Q[1]), .Qbar(Qbar[1]), .D(D[1]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg2(.Q(Q[2]), .Qbar(Qbar[2]), .D(D[2]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg3(.Q(Q[3]), .Qbar(Qbar[3]), .D(D[3]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg4(.Q(Q[4]), .Qbar(Qbar[4]), .D(D[4]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg5(.Q(Q[5]), .Qbar(Qbar[5]), .D(D[5]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg6(.Q(Q[6]), .Qbar(Qbar[6]), .D(D[6]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg7(.Q(Q[7]), .Qbar(Qbar[7]), .D(D[7]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg8(.Q(Q[8]), .Qbar(Qbar[8]), .D(D[8]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg9(.Q(Q[9]), .Qbar(Qbar[9]), .D(D[9]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg10(.Q(Q[10]), .Qbar(Qbar[10]), .D(D[10]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg11(.Q(Q[11]), .Qbar(Qbar[11]), .D(D[11]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg12(.Q(Q[12]), .Qbar(Qbar[12]), .D(D[12]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg13(.Q(Q[13]), .Qbar(Qbar[13]), .D(D[13]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg14(.Q(Q[14]), .Qbar(Qbar[14]), .D(D[14]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg15(.Q(Q[15]), .Qbar(Qbar[15]), .D(D[15]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg16(.Q(Q[16]), .Qbar(Qbar[16]), .D(D[16]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg17(.Q(Q[17]), .Qbar(Qbar[17]), .D(D[17]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg18(.Q(Q[18]), .Qbar(Qbar[18]), .D(D[18]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg19(.Q(Q[19]), .Qbar(Qbar[19]), .D(D[19]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg20(.Q(Q[20]), .Qbar(Qbar[20]), .D(D[20]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg21(.Q(Q[21]), .Qbar(Qbar[21]), .D(D[21]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg22(.Q(Q[22]), .Qbar(Qbar[22]), .D(D[22]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg23(.Q(Q[23]), .Qbar(Qbar[23]), .D(D[23]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg24(.Q(Q[24]), .Qbar(Qbar[24]), .D(D[24]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg25(.Q(Q[25]), .Qbar(Qbar[25]), .D(D[25]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg26(.Q(Q[26]), .Qbar(Qbar[26]), .D(D[26]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg27(.Q(Q[27]), .Qbar(Qbar[27]), .D(D[27]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg28(.Q(Q[28]), .Qbar(Qbar[28]), .D(D[28]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg29(.Q(Q[29]), .Qbar(Qbar[29]), .D(D[29]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg30(.Q(Q[30]), .Qbar(Qbar[30]), .D(D[30]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));
REG1 reg31(.Q(Q[31]), .Qbar(Qbar[31]), .D(D[31]), .L(LOAD), .C(CLK), .nP(one), .nR(RESET));

endmodule

// 1 bit register +ve edge, 
// Preset on nP=0, nR=1, reset on nP=1, nR=0;
// Undefined nP=0, nR=0
// normal operation nP=1, nR=1
module REG1(Q, Qbar, D, L, C, nP, nR);
input D, C, L;
input nP, nR;
output Q,Qbar;

// TBD
wire selectedD;

MUX1_2x1 mux(.Y(selectedD), .I0(Q), .I1(D), .S(L));
D_FF flip_flop(.Q(Q), .Qbar(Qbar), .D(selectedD), .C(C), .nP(nP), .nR(nR));

endmodule

// 1 bit flipflop +ve edge, 
// Preset on nP=0, nR=1, reset on nP=1, nR=0;
// Undefined nP=0, nR=0
// normal operation nP=1, nR=1
module D_FF(Q, Qbar, D, C, nP, nR);
input D, C;
input nP, nR;
output Q,Qbar;

// TBD
wire DRes;
wire CRes;
wire PRes;
wire RRes;
wire Dnot;
wire Cnot;
wire D_Latch_Q, D_Latch_QBar;
assign Dnot = ~D;
assign Cnot = ~C;

wire SR_DRes, SR_CRes;
wire SR_PRes, SR_RRes;

nand nand1(DRes, D, C);
nand nand2(CRes, C, Dnot);

and and1(PRes, DRes, nP);
nand nand3(D_Latch_Q, D_Latch_Qbar, PRes);
and and2(RRes, nR, CRes);
nand nand4(D_Latch_Qbar, D_Latch_Q, RRes);

nand nand5(SR_DRes, D_Latch_Q, Cnot);
nand nand6(SR_CRes, D_Latch_Qbar, Cnot);

and and3(SR_PRes, SR_DRes, nP);
nand nand7(Q, SR_PRes, Qbar);
and and4(SR_RRes, SR_CRes, nR);
nand nand8(Qbar, SR_RRes, Q);


endmodule

// 1 bit D latch
// Preset on nP=0, nR=1, reset on nP=1, nR=0;
// Undefined nP=0, nR=0
// normal operation nP=1, nR=1
module D_LATCH(Q, Qbar, D, C, nP, nR);
input D, C;
input nP, nR;
output Q,Qbar;

// TBD
wire DRes;
wire RRes;
wire R;
assign R = ~D;

nand nand1(DRes, D, C);
nand nand2(RRes, C, R);

nand nand3(Q, Qbar, DRes);
nand nand4(Qbar, Q, RRes);

endmodule

// 1 bit SR latch
// Preset on nP=0, nR=1, reset on nP=1, nR=0;
// Undefined nP=0, nR=0
// normal operation nP=1, nR=1
module SR_LATCH(Q,Qbar, S, R, C, nP, nR);
input S, R, C;
input nP, nR;
output Q,Qbar;

// TBD
wire SRes;
wire RRes;

nand nand1(SRes, S, C);
nand nand2(RRes, C, R);

nand nand3(Q, Qbar, SRes);
nand nand4(Qbar, Q, RRes);

endmodule

// 5x32 Line decoder
module DECODER_5x32(D,I);
// output
output [31:0] D;
// input
input [4:0] I;

// TBD
wire [15:0] tempD;
wire I4_Not;
assign I4_Not = ~I[4];
DECODER_4x16 D_4x8(.D(tempD),.I(I[3:0]));

and and0(D[0], tempD[0], I4_Not);
and and1(D[1], tempD[1], I4_Not);
and and2(D[2], tempD[2], I4_Not);
and and3(D[3], tempD[3], I4_Not);
and and4(D[4], tempD[4], I4_Not);
and and5(D[5], tempD[5], I4_Not);
and and6(D[6], tempD[6], I4_Not);
and and7(D[7], tempD[7], I4_Not);
and and8(D[8], tempD[8], I4_Not);
and and9(D[9], tempD[9], I4_Not);
and and10(D[10], tempD[10], I4_Not);
and and11(D[11], tempD[11], I4_Not);
and and12(D[12], tempD[12], I4_Not);
and and13(D[13], tempD[13], I4_Not);
and and14(D[14], tempD[14], I4_Not);
and and15(D[15], tempD[15], I4_Not);
and and16(D[16], tempD[0], I[4]);
and and17(D[17], tempD[1], I[4]);
and and18(D[18], tempD[2], I[4]);
and and19(D[19], tempD[3], I[4]);
and and20(D[20], tempD[4], I[4]);
and and21(D[21], tempD[5], I[4]);
and and22(D[22], tempD[6], I[4]);
and and23(D[23], tempD[7], I[4]);
and and24(D[24], tempD[8], I[4]);
and and25(D[25], tempD[9], I[4]);
and and26(D[26], tempD[10], I[4]);
and and27(D[27], tempD[11], I[4]);
and and28(D[28], tempD[12], I[4]);
and and29(D[29], tempD[13], I[4]);
and and30(D[30], tempD[14], I[4]);
and and31(D[31], tempD[15], I[4]);

endmodule

// 4x16 Line decoder
module DECODER_4x16(D,I);
// output
output [15:0] D;
// input
input [3:0] I;

// TBD
wire [7:0] tempD;
wire I3_Not;
assign I3_Not = ~I[3];
DECODER_3x8 D_3x8(.D(tempD), .I(I[2:0]));

and and0(D[0], tempD[0], I3_Not);
and and1(D[1], tempD[1], I3_Not);
and and2(D[2], tempD[2], I3_Not);
and and3(D[3], tempD[3], I3_Not);
and and4(D[4], tempD[4], I3_Not);
and and5(D[5], tempD[5], I3_Not);
and and6(D[6], tempD[6], I3_Not);
and and7(D[7], tempD[7], I3_Not);
and and8(D[8], tempD[0], I[3]);
and and9(D[9], tempD[1], I[3]);
and and10(D[10], tempD[2], I[3]);
and and11(D[11], tempD[3], I[3]);
and and12(D[12], tempD[4], I[3]);
and and13(D[13], tempD[5], I[3]);
and and14(D[14], tempD[6], I[3]);
and and15(D[15], tempD[7], I[3]);

endmodule

// 3x8 Line decoder
module DECODER_3x8(D,I);
// output
output [7:0] D;
// input
input [2:0] I;

//TBD
wire [3:0] tempD;
wire I2_Not;
assign I2_Not = ~I[2];
DECODER_2x4 D_2x4(.D(tempD),.I(I[1:0]));

and and0(D[0], tempD[0], I2_Not);
and and1(D[1], tempD[1], I2_Not);
and and2(D[2], tempD[2], I2_Not);
and and3(D[3], tempD[3], I2_Not);
and and4(D[4], tempD[0], I[2]);
and and5(D[5], tempD[1], I[2]);
and and6(D[6], tempD[2], I[2]);
and and7(D[7], tempD[3], I[2]);

endmodule

// 2x4 Line decoder
module DECODER_2x4(D,I);
// output
output [3:0] D;
// input
input [1:0] I;

wire I0_not, I1_not;
assign I0_not = ~I[0];
assign I1_not = ~I[1];


// TBD
and and0(D[0], I0_not, I1_not);
and and1(D[1], I[0], I1_not);
and and2(D[2], I0_not, I[1]);
and and3(D[3], I[0], I[1]);


endmodule