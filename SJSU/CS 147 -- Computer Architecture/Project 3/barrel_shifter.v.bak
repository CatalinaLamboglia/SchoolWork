// Name: barrel_shifter.v
// Module: SHIFT32_L , SHIFT32_R, SHIFT32
//
// Notes: 32-bit barrel shifter
// 
//
// Revision History:
//
// Version	Date		Who		email			note
//------------------------------------------------------------------------------------------
//  1.0     Sep 10, 2014	Kaushik Patra	kpatra@sjsu.edu		Initial creation
//------------------------------------------------------------------------------------------
`include "prj_definition.v"

// 32-bit shift amount shifter
module SHIFT32(Y,D,S, LnR);
// output list
output [31:0] Y;
// input list
input [31:0] D;
input [31:0] S;
input LnR;

wire sel;
wire [31:0] res;

wire or_res_5;
wire or_res_6;
wire or_res_7;
wire or_res_8;
wire or_res_9;
wire or_res_10;
wire or_res_11;
wire or_res_12;
wire or_res_13;
wire or_res_14;
wire or_res_15;
wire or_res_16;
wire or_res_17;
wire or_res_18;
wire or_res_19;
wire or_res_20;
wire or_res_21;
wire or_res_22;
wire or_res_23;
wire or_res_24;
wire or_res_25;
wire or_res_26;
wire or_res_27;
wire or_res_28;
wire or_res_29;

wire [31:0] zero_32;
assign zero_32 = 32'b0;

// TBD
//module BARREL_SHIFTER32(Y,D,S, LnR);
BARREL_SHIFTER32 shifter(.Y(res), .D(D), .S(S[4:0]), .LnR(LnR));

or or5(or_res_5, S[5], S[6]);
or or6(or_res_6, or_res_5, S[7]);
or or7(or_res_7, or_res_6, S[8]);
or or8(or_res_8, or_res_7, S[9]);
or or9(or_res_9, or_res_8, S[10]);
or or10(or_res_10, or_res_9, S[11]);
or or11(or_res_11, or_res_10, S[12]);
or or12(or_res_12, or_res_11, S[13]);
or or13(or_res_13, or_res_12, S[14]);
or or14(or_res_14, or_res_13, S[15]);
or or15(or_res_15, or_res_14, S[16]);
or or16(or_res_16, or_res_15, S[17]);
or or17(or_res_17, or_res_16, S[18]);
or or18(or_res_18, or_res_17, S[19]);
or or19(or_res_19, or_res_18, S[20]);
or or20(or_res_20, or_res_19, S[21]);
or or21(or_res_21, or_res_20, S[22]);
or or22(or_res_22, or_res_21, S[23]);
or or23(or_res_23, or_res_22, S[24]);
or or24(or_res_24, or_res_23, S[25]);
or or25(or_res_25, or_res_24, S[26]);
or or26(or_res_26, or_res_25, S[27]);
or or27(or_res_27, or_res_26, S[28]);
or or28(or_res_28, or_res_27, S[29]);
or or29(or_res_29, or_res_28, S[30]);
or or30(sel, or_res_29, S[31]);

MUX32_2x1 mux(.Y(Y), .I0(res), .I1(zero_32), .S(sel));

endmodule

// Shift with control L or R shift
module BARREL_SHIFTER32(Y,D,S, LnR);
// output list
output [31:0] Y;
// input list
input [31:0] D;
input [4:0] S;
input LnR;

// TBD

wire [31:0] Y_R;
wire [31:0] Y_L;


//module SHIFT32_L(Y,D,S);
SHIFT32_L shift_left(.Y(Y_L), .D(D), .S(S));
SHIFT32_R shift_right(.Y(Y_R), .D(D), .S(S));

MUX32_2x1 mux(.Y(Y), .I0(Y_R), .I1(Y_L), .S(LnR));

endmodule

// Right shifter
module SHIFT32_R(Y,D,S);
// output list
output [31:0] Y;
// input list
input [31:0] D;
input [4:0] S;

// TBD
wire firstShift0;
wire firstShift1;
wire firstShift2;
wire firstShift3;
wire firstShift4;
wire firstShift5;
wire firstShift6;
wire firstShift7;
wire firstShift8;
wire firstShift9;
wire firstShift10;
wire firstShift11;
wire firstShift12;
wire firstShift13;
wire firstShift14;
wire firstShift15;
wire firstShift16;
wire firstShift17;
wire firstShift18;
wire firstShift19;
wire firstShift20;
wire firstShift21;
wire firstShift22;
wire firstShift23;
wire firstShift24;
wire firstShift25;
wire firstShift26;
wire firstShift27;
wire firstShift28;
wire firstShift29;
wire firstShift30;
wire firstShift31;

wire secondShift0;
wire secondShift1;
wire secondShift2;
wire secondShift3;
wire secondShift4;
wire secondShift5;
wire secondShift6;
wire secondShift7;
wire secondShift8;
wire secondShift9;
wire secondShift10;
wire secondShift11;
wire secondShift12;
wire secondShift13;
wire secondShift14;
wire secondShift15;
wire secondShift16;
wire secondShift17;
wire secondShift18;
wire secondShift19;
wire secondShift20;
wire secondShift21;
wire secondShift22;
wire secondShift23;
wire secondShift24;
wire secondShift25;
wire secondShift26;
wire secondShift27;
wire secondShift28;
wire secondShift29;
wire secondShift30;
wire secondShift31;

wire thirdShift0;
wire thirdShift1;
wire thirdShift2;
wire thirdShift3;
wire thirdShift4;
wire thirdShift5;
wire thirdShift6;
wire thirdShift7;
wire thirdShift8;
wire thirdShift9;
wire thirdShift10;
wire thirdShift11;
wire thirdShift12;
wire thirdShift13;
wire thirdShift14;
wire thirdShift15;
wire thirdShift16;
wire thirdShift17;
wire thirdShift18;
wire thirdShift19;
wire thirdShift20;
wire thirdShift21;
wire thirdShift22;
wire thirdShift23;
wire thirdShift24;
wire thirdShift25;
wire thirdShift26;
wire thirdShift27;
wire thirdShift28;
wire thirdShift29;
wire thirdShift30;
wire thirdShift31;

wire fourthShift0;
wire fourthShift1;
wire fourthShift2;
wire fourthShift3;
wire fourthShift4;
wire fourthShift5;
wire fourthShift6;
wire fourthShift7;
wire fourthShift8;
wire fourthShift9;
wire fourthShift10;
wire fourthShift11;
wire fourthShift12;
wire fourthShift13;
wire fourthShift14;
wire fourthShift15;
wire fourthShift16;
wire fourthShift17;
wire fourthShift18;
wire fourthShift19;
wire fourthShift20;
wire fourthShift21;
wire fourthShift22;
wire fourthShift23;
wire fourthShift24;
wire fourthShift25;
wire fourthShift26;
wire fourthShift27;
wire fourthShift28;
wire fourthShift29;
wire fourthShift30;
wire fourthShift31;

wire zeroBit;
assign zeroBit = 1'b0;

MUX1_2x1 mux_first_0(.Y(firstShift0), .I0(D[0]), .I1(D[1]), .S(S[0]));
MUX1_2x1 mux_first_1(.Y(firstShift1), .I0(D[1]), .I1(D[2]), .S(S[0]));
MUX1_2x1 mux_first_2(.Y(firstShift2), .I0(D[2]), .I1(D[3]), .S(S[0]));
MUX1_2x1 mux_first_3(.Y(firstShift3), .I0(D[3]), .I1(D[4]), .S(S[0]));
MUX1_2x1 mux_first_4(.Y(firstShift4), .I0(D[4]), .I1(D[5]), .S(S[0]));
MUX1_2x1 mux_first_5(.Y(firstShift5), .I0(D[5]), .I1(D[6]), .S(S[0]));
MUX1_2x1 mux_first_6(.Y(firstShift6), .I0(D[6]), .I1(D[7]), .S(S[0]));
MUX1_2x1 mux_first_7(.Y(firstShift7), .I0(D[7]), .I1(D[8]), .S(S[0]));
MUX1_2x1 mux_first_8(.Y(firstShift8), .I0(D[8]), .I1(D[9]), .S(S[0]));
MUX1_2x1 mux_first_9(.Y(firstShift9), .I0(D[9]), .I1(D[10]), .S(S[0]));
MUX1_2x1 mux_first_10(.Y(firstShift10), .I0(D[10]), .I1(D[11]), .S(S[0]));
MUX1_2x1 mux_first_11(.Y(firstShift11), .I0(D[11]), .I1(D[12]), .S(S[0]));
MUX1_2x1 mux_first_12(.Y(firstShift12), .I0(D[12]), .I1(D[13]), .S(S[0]));
MUX1_2x1 mux_first_13(.Y(firstShift13), .I0(D[13]), .I1(D[14]), .S(S[0]));
MUX1_2x1 mux_first_14(.Y(firstShift14), .I0(D[14]), .I1(D[15]), .S(S[0]));
MUX1_2x1 mux_first_15(.Y(firstShift15), .I0(D[15]), .I1(D[16]), .S(S[0]));
MUX1_2x1 mux_first_16(.Y(firstShift16), .I0(D[16]), .I1(D[17]), .S(S[0]));
MUX1_2x1 mux_first_17(.Y(firstShift17), .I0(D[17]), .I1(D[18]), .S(S[0]));
MUX1_2x1 mux_first_18(.Y(firstShift18), .I0(D[18]), .I1(D[19]), .S(S[0]));
MUX1_2x1 mux_first_19(.Y(firstShift19), .I0(D[19]), .I1(D[20]), .S(S[0]));
MUX1_2x1 mux_first_20(.Y(firstShift20), .I0(D[20]), .I1(D[21]), .S(S[0]));
MUX1_2x1 mux_first_21(.Y(firstShift21), .I0(D[21]), .I1(D[22]), .S(S[0]));
MUX1_2x1 mux_first_22(.Y(firstShift22), .I0(D[22]), .I1(D[23]), .S(S[0]));
MUX1_2x1 mux_first_23(.Y(firstShift23), .I0(D[23]), .I1(D[24]), .S(S[0]));
MUX1_2x1 mux_first_24(.Y(firstShift24), .I0(D[24]), .I1(D[25]), .S(S[0]));
MUX1_2x1 mux_first_25(.Y(firstShift25), .I0(D[25]), .I1(D[26]), .S(S[0]));
MUX1_2x1 mux_first_26(.Y(firstShift26), .I0(D[26]), .I1(D[27]), .S(S[0]));
MUX1_2x1 mux_first_27(.Y(firstShift27), .I0(D[27]), .I1(D[28]), .S(S[0]));
MUX1_2x1 mux_first_28(.Y(firstShift28), .I0(D[28]), .I1(D[29]), .S(S[0]));
MUX1_2x1 mux_first_29(.Y(firstShift29), .I0(D[29]), .I1(D[30]), .S(S[0]));
MUX1_2x1 mux_first_30(.Y(firstShift30), .I0(D[30]), .I1(D[31]), .S(S[0]));
MUX1_2x1 mux_first_31(.Y(firstShift31), .I0(D[31]), .I1(zeroBit), .S(S[0]));

MUX1_2x1 mux_second_0(.Y(secondShift0), .I0(firstShift0), .I1(firstShift2), .S(S[1]));
MUX1_2x1 mux_second_1(.Y(secondShift1), .I0(firstShift1), .I1(firstShift3), .S(S[1]));
MUX1_2x1 mux_second_2(.Y(secondShift2), .I0(firstShift2), .I1(firstShift4), .S(S[1]));
MUX1_2x1 mux_second_3(.Y(secondShift3), .I0(firstShift3), .I1(firstShift5), .S(S[1]));
MUX1_2x1 mux_second_4(.Y(secondShift4), .I0(firstShift4), .I1(firstShift6), .S(S[1]));
MUX1_2x1 mux_second_5(.Y(secondShift5), .I0(firstShift5), .I1(firstShift7), .S(S[1]));
MUX1_2x1 mux_second_6(.Y(secondShift6), .I0(firstShift6), .I1(firstShift8), .S(S[1]));
MUX1_2x1 mux_second_7(.Y(secondShift7), .I0(firstShift7), .I1(firstShift9), .S(S[1]));
MUX1_2x1 mux_second_8(.Y(secondShift8), .I0(firstShift8), .I1(firstShift10), .S(S[1]));
MUX1_2x1 mux_second_9(.Y(secondShift9), .I0(firstShift9), .I1(firstShift11), .S(S[1]));
MUX1_2x1 mux_second_10(.Y(secondShift10), .I0(firstShift10), .I1(firstShift12), .S(S[1]));
MUX1_2x1 mux_second_11(.Y(secondShift11), .I0(firstShift11), .I1(firstShift13), .S(S[1]));
MUX1_2x1 mux_second_12(.Y(secondShift12), .I0(firstShift12), .I1(firstShift14), .S(S[1]));
MUX1_2x1 mux_second_13(.Y(secondShift13), .I0(firstShift13), .I1(firstShift15), .S(S[1]));
MUX1_2x1 mux_second_14(.Y(secondShift14), .I0(firstShift14), .I1(firstShift16), .S(S[1]));
MUX1_2x1 mux_second_15(.Y(secondShift15), .I0(firstShift15), .I1(firstShift17), .S(S[1]));
MUX1_2x1 mux_second_16(.Y(secondShift16), .I0(firstShift16), .I1(firstShift18), .S(S[1]));
MUX1_2x1 mux_second_17(.Y(secondShift17), .I0(firstShift17), .I1(firstShift19), .S(S[1]));
MUX1_2x1 mux_second_18(.Y(secondShift18), .I0(firstShift18), .I1(firstShift20), .S(S[1]));
MUX1_2x1 mux_second_19(.Y(secondShift19), .I0(firstShift19), .I1(firstShift21), .S(S[1]));
MUX1_2x1 mux_second_20(.Y(secondShift20), .I0(firstShift20), .I1(firstShift22), .S(S[1]));
MUX1_2x1 mux_second_21(.Y(secondShift21), .I0(firstShift21), .I1(firstShift23), .S(S[1]));
MUX1_2x1 mux_second_22(.Y(secondShift22), .I0(firstShift22), .I1(firstShift24), .S(S[1]));
MUX1_2x1 mux_second_23(.Y(secondShift23), .I0(firstShift23), .I1(firstShift25), .S(S[1]));
MUX1_2x1 mux_second_24(.Y(secondShift24), .I0(firstShift24), .I1(firstShift26), .S(S[1]));
MUX1_2x1 mux_second_25(.Y(secondShift25), .I0(firstShift25), .I1(firstShift27), .S(S[1]));
MUX1_2x1 mux_second_26(.Y(secondShift26), .I0(firstShift26), .I1(firstShift28), .S(S[1]));
MUX1_2x1 mux_second_27(.Y(secondShift27), .I0(firstShift27), .I1(firstShift29), .S(S[1]));
MUX1_2x1 mux_second_28(.Y(secondShift28), .I0(firstShift28), .I1(firstShift30), .S(S[1]));
MUX1_2x1 mux_second_29(.Y(secondShift29), .I0(firstShift29), .I1(firstShift31), .S(S[1]));
MUX1_2x1 mux_second_30(.Y(secondShift30), .I0(firstShift30), .I1(zeroBit), .S(S[1]));
MUX1_2x1 mux_second_31(.Y(secondShift31), .I0(firstShift31), .I1(zeroBit), .S(S[1]));

MUX1_2x1 mux_third_0(.Y(thirdShift0), .I0(secondShift0), .I1(secondShift4), .S(S[2]));
MUX1_2x1 mux_third_1(.Y(thirdShift1), .I0(secondShift1), .I1(secondShift5), .S(S[2]));
MUX1_2x1 mux_third_2(.Y(thirdShift2), .I0(secondShift2), .I1(secondShift6), .S(S[2]));
MUX1_2x1 mux_third_3(.Y(thirdShift3), .I0(secondShift3), .I1(secondShift7), .S(S[2])); 
MUX1_2x1 mux_third_4(.Y(thirdShift4), .I0(secondShift4), .I1(secondShift8), .S(S[2]));
MUX1_2x1 mux_third_5(.Y(thirdShift5), .I0(secondShift5), .I1(secondShift9), .S(S[2])); 
MUX1_2x1 mux_third_6(.Y(thirdShift6), .I0(secondShift6), .I1(secondShift10), .S(S[2]));
MUX1_2x1 mux_third_7(.Y(thirdShift7), .I0(secondShift7), .I1(secondShift11), .S(S[2]));
MUX1_2x1 mux_third_8(.Y(thirdShift8), .I0(secondShift8), .I1(secondShift12), .S(S[2]));
MUX1_2x1 mux_third_9(.Y(thirdShift9), .I0(secondShift9), .I1(secondShift13), .S(S[2]));
MUX1_2x1 mux_third_10(.Y(thirdShift10), .I0(secondShift10), .I1(secondShift14), .S(S[2]));
MUX1_2x1 mux_third_11(.Y(thirdShift11), .I0(secondShift11), .I1(secondShift15), .S(S[2]));
MUX1_2x1 mux_third_12(.Y(thirdShift12), .I0(secondShift12), .I1(secondShift16), .S(S[2]));
MUX1_2x1 mux_third_13(.Y(thirdShift13), .I0(secondShift13), .I1(secondShift17), .S(S[2]));
MUX1_2x1 mux_third_14(.Y(thirdShift14), .I0(secondShift14), .I1(secondShift18), .S(S[2]));
MUX1_2x1 mux_third_15(.Y(thirdShift15), .I0(secondShift15), .I1(secondShift19), .S(S[2]));
MUX1_2x1 mux_third_16(.Y(thirdShift16), .I0(secondShift16), .I1(secondShift20), .S(S[2]));
MUX1_2x1 mux_third_17(.Y(thirdShift17), .I0(secondShift17), .I1(secondShift21), .S(S[2]));
MUX1_2x1 mux_third_18(.Y(thirdShift18), .I0(secondShift18), .I1(secondShift22), .S(S[2]));
MUX1_2x1 mux_third_19(.Y(thirdShift19), .I0(secondShift19), .I1(secondShift23), .S(S[2]));
MUX1_2x1 mux_third_20(.Y(thirdShift20), .I0(secondShift20), .I1(secondShift24), .S(S[2]));
MUX1_2x1 mux_third_21(.Y(thirdShift21), .I0(secondShift21), .I1(secondShift25), .S(S[2]));
MUX1_2x1 mux_third_22(.Y(thirdShift22), .I0(secondShift22), .I1(secondShift26), .S(S[2]));
MUX1_2x1 mux_third_23(.Y(thirdShift23), .I0(secondShift23), .I1(secondShift27), .S(S[2]));
MUX1_2x1 mux_third_24(.Y(thirdShift24), .I0(secondShift24), .I1(secondShift28), .S(S[2]));
MUX1_2x1 mux_third_25(.Y(thirdShift25), .I0(secondShift25), .I1(secondShift29), .S(S[2]));
MUX1_2x1 mux_third_26(.Y(thirdShift26), .I0(secondShift26), .I1(secondShift30), .S(S[2]));
MUX1_2x1 mux_third_27(.Y(thirdShift27), .I0(secondShift27), .I1(secondShift31), .S(S[2]));
MUX1_2x1 mux_third_28(.Y(thirdShift28), .I0(secondShift28), .I1(zeroBit), .S(S[2])); // fourth
MUX1_2x1 mux_third_29(.Y(thirdShift29), .I0(secondShift29), .I1(zeroBit), .S(S[2]));
MUX1_2x1 mux_third_30(.Y(thirdShift30), .I0(secondShift30), .I1(zeroBit), .S(S[2]));
MUX1_2x1 mux_third_31(.Y(thirdShift31), .I0(secondShift31), .I1(zeroBit), .S(S[2]));

MUX1_2x1 mux_fourth_0(.Y(fourthShift0), .I0(thirdShift0), .I1(thirdShift8), .S(S[3]));
MUX1_2x1 mux_fourth_1(.Y(fourthShift1), .I0(thirdShift1), .I1(thirdShift9), .S(S[3]));
MUX1_2x1 mux_fourth_2(.Y(fourthShift2), .I0(thirdShift2), .I1(thirdShift10), .S(S[3]));
MUX1_2x1 mux_fourth_3(.Y(fourthShift3), .I0(thirdShift3), .I1(thirdShift11), .S(S[3]));
MUX1_2x1 mux_fourth_4(.Y(fourthShift4), .I0(thirdShift4), .I1(thirdShift12), .S(S[3]));
MUX1_2x1 mux_fourth_5(.Y(fourthShift5), .I0(thirdShift5), .I1(thirdShift13), .S(S[3]));
MUX1_2x1 mux_fourth_6(.Y(fourthShift6), .I0(thirdShift6), .I1(thirdShift14), .S(S[3]));
MUX1_2x1 mux_fourth_7(.Y(fourthShift7), .I0(thirdShift7), .I1(thirdShift15), .S(S[3]));
MUX1_2x1 mux_fourth_8(.Y(fourthShift8), .I0(thirdShift8), .I1(thirdShift16), .S(S[3]));
MUX1_2x1 mux_fourth_9(.Y(fourthShift9), .I0(thirdShift9), .I1(thirdShift17), .S(S[3]));
MUX1_2x1 mux_fourth_10(.Y(fourthShift10), .I0(thirdShift10), .I1(thirdShift18), .S(S[3]));
MUX1_2x1 mux_fourth_11(.Y(fourthShift11), .I0(thirdShift11), .I1(thirdShift19), .S(S[3]));
MUX1_2x1 mux_fourth_12(.Y(fourthShift12), .I0(thirdShift12), .I1(thirdShift20), .S(S[3]));
MUX1_2x1 mux_fourth_13(.Y(fourthShift13), .I0(thirdShift13), .I1(thirdShift21), .S(S[3]));
MUX1_2x1 mux_fourth_14(.Y(fourthShift14), .I0(thirdShift14), .I1(thirdShift22), .S(S[3]));
MUX1_2x1 mux_fourth_15(.Y(fourthShift15), .I0(thirdShift15), .I1(thirdShift23), .S(S[3]));
MUX1_2x1 mux_fourth_16(.Y(fourthShift16), .I0(thirdShift16), .I1(thirdShift24), .S(S[3]));
MUX1_2x1 mux_fourth_17(.Y(fourthShift17), .I0(thirdShift17), .I1(thirdShift25), .S(S[3]));
MUX1_2x1 mux_fourth_18(.Y(fourthShift18), .I0(thirdShift18), .I1(thirdShift26), .S(S[3]));
MUX1_2x1 mux_fourth_19(.Y(fourthShift19), .I0(thirdShift19), .I1(thirdShift27), .S(S[3]));
MUX1_2x1 mux_fourth_20(.Y(fourthShift20), .I0(thirdShift20), .I1(thirdShift28), .S(S[3]));
MUX1_2x1 mux_fourth_21(.Y(fourthShift21), .I0(thirdShift21), .I1(thirdShift29), .S(S[3]));
MUX1_2x1 mux_fourth_22(.Y(fourthShift22), .I0(thirdShift22), .I1(thirdShift30), .S(S[3]));
MUX1_2x1 mux_fourth_23(.Y(fourthShift23), .I0(thirdShift23), .I1(thirdShift31), .S(S[3]));
MUX1_2x1 mux_fourth_24(.Y(fourthShift24), .I0(thirdShift24), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_25(.Y(fourthShift25), .I0(thirdShift25), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_26(.Y(fourthShift26), .I0(thirdShift26), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_27(.Y(fourthShift27), .I0(thirdShift27), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_28(.Y(fourthShift28), .I0(thirdShift28), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_29(.Y(fourthShift29), .I0(thirdShift29), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_30(.Y(fourthShift30), .I0(thirdShift30), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_31(.Y(fourthShift31), .I0(thirdShift31), .I1(zeroBit), .S(S[3]));

MUX1_2x1 mux_fifth_0(.Y(Y[0]), .I0(fourthShift0), .I1(fourthShift16), .S(S[4]));
MUX1_2x1 mux_fifth_1(.Y(Y[1]), .I0(fourthShift1), .I1(fourthShift17), .S(S[4]));
MUX1_2x1 mux_fifth_2(.Y(Y[2]), .I0(fourthShift2), .I1(fourthShift18), .S(S[4]));
MUX1_2x1 mux_fifth_3(.Y(Y[3]), .I0(fourthShift3), .I1(fourthShift19), .S(S[4]));
MUX1_2x1 mux_fifth_4(.Y(Y[4]), .I0(fourthShift4), .I1(fourthShift20), .S(S[4]));
MUX1_2x1 mux_fifth_5(.Y(Y[5]), .I0(fourthShift5), .I1(fourthShift21), .S(S[4]));
MUX1_2x1 mux_fifth_6(.Y(Y[6]), .I0(fourthShift6), .I1(fourthShift22), .S(S[4]));
MUX1_2x1 mux_fifth_7(.Y(Y[7]), .I0(fourthShift7), .I1(fourthShift23), .S(S[4]));
MUX1_2x1 mux_fifth_8(.Y(Y[8]), .I0(fourthShift8), .I1(fourthShift24), .S(S[4]));
MUX1_2x1 mux_fifth_9(.Y(Y[9]), .I0(fourthShift9), .I1(fourthShift25), .S(S[4]));
MUX1_2x1 mux_fifth_10(.Y(Y[10]), .I0(fourthShift10), .I1(fourthShift26), .S(S[4]));
MUX1_2x1 mux_fifth_11(.Y(Y[11]), .I0(fourthShift11), .I1(fourthShift27), .S(S[4]));
MUX1_2x1 mux_fifth_12(.Y(Y[12]), .I0(fourthShift12), .I1(fourthShift28), .S(S[4]));
MUX1_2x1 mux_fifth_13(.Y(Y[13]), .I0(fourthShift13), .I1(fourthShift29), .S(S[4]));
MUX1_2x1 mux_fifth_14(.Y(Y[14]), .I0(fourthShift14), .I1(fourthShift30), .S(S[4]));
MUX1_2x1 mux_fifth_15(.Y(Y[15]), .I0(fourthShift15), .I1(fourthShift31), .S(S[4]));
MUX1_2x1 mux_fifth_16(.Y(Y[16]), .I0(fourthShift16), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_17(.Y(Y[17]), .I0(fourthShift17), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_18(.Y(Y[18]), .I0(fourthShift18), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_19(.Y(Y[19]), .I0(fourthShift19), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_20(.Y(Y[20]), .I0(fourthShift20), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_21(.Y(Y[21]), .I0(fourthShift21), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_22(.Y(Y[22]), .I0(fourthShift22), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_23(.Y(Y[23]), .I0(fourthShift23), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_24(.Y(Y[24]), .I0(fourthShift24), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_25(.Y(Y[25]), .I0(fourthShift25), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_26(.Y(Y[26]), .I0(fourthShift26), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_27(.Y(Y[27]), .I0(fourthShift27), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_28(.Y(Y[28]), .I0(fourthShift28), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_29(.Y(Y[29]), .I0(fourthShift29), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_30(.Y(Y[30]), .I0(fourthShift30), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_31(.Y(Y[31]), .I0(fourthShift31), .I1(zeroBit), .S(S[4]));

endmodule

// Left shifter
module SHIFT32_L(Y,D,S);
// output list
output [31:0] Y;
// input list
input [31:0] D;
input [4:0] S;

// TBD

wire firstShift0;
wire firstShift1;
wire firstShift2;
wire firstShift3;
wire firstShift4;
wire firstShift5;
wire firstShift6;
wire firstShift7;
wire firstShift8;
wire firstShift9;
wire firstShift10;
wire firstShift11;
wire firstShift12;
wire firstShift13;
wire firstShift14;
wire firstShift15;
wire firstShift16;
wire firstShift17;
wire firstShift18;
wire firstShift19;
wire firstShift20;
wire firstShift21;
wire firstShift22;
wire firstShift23;
wire firstShift24;
wire firstShift25;
wire firstShift26;
wire firstShift27;
wire firstShift28;
wire firstShift29;
wire firstShift30;
wire firstShift31;

wire secondShift0;
wire secondShift1;
wire secondShift2;
wire secondShift3;
wire secondShift4;
wire secondShift5;
wire secondShift6;
wire secondShift7;
wire secondShift8;
wire secondShift9;
wire secondShift10;
wire secondShift11;
wire secondShift12;
wire secondShift13;
wire secondShift14;
wire secondShift15;
wire secondShift16;
wire secondShift17;
wire secondShift18;
wire secondShift19;
wire secondShift20;
wire secondShift21;
wire secondShift22;
wire secondShift23;
wire secondShift24;
wire secondShift25;
wire secondShift26;
wire secondShift27;
wire secondShift28;
wire secondShift29;
wire secondShift30;
wire secondShift31;

wire thirdShift0;
wire thirdShift1;
wire thirdShift2;
wire thirdShift3;
wire thirdShift4;
wire thirdShift5;
wire thirdShift6;
wire thirdShift7;
wire thirdShift8;
wire thirdShift9;
wire thirdShift10;
wire thirdShift11;
wire thirdShift12;
wire thirdShift13;
wire thirdShift14;
wire thirdShift15;
wire thirdShift16;
wire thirdShift17;
wire thirdShift18;
wire thirdShift19;
wire thirdShift20;
wire thirdShift21;
wire thirdShift22;
wire thirdShift23;
wire thirdShift24;
wire thirdShift25;
wire thirdShift26;
wire thirdShift27;
wire thirdShift28;
wire thirdShift29;
wire thirdShift30;
wire thirdShift31;

wire fourthShift0;
wire fourthShift1;
wire fourthShift2;
wire fourthShift3;
wire fourthShift4;
wire fourthShift5;
wire fourthShift6;
wire fourthShift7;
wire fourthShift8;
wire fourthShift9;
wire fourthShift10;
wire fourthShift11;
wire fourthShift12;
wire fourthShift13;
wire fourthShift14;
wire fourthShift15;
wire fourthShift16;
wire fourthShift17;
wire fourthShift18;
wire fourthShift19;
wire fourthShift20;
wire fourthShift21;
wire fourthShift22;
wire fourthShift23;
wire fourthShift24;
wire fourthShift25;
wire fourthShift26;
wire fourthShift27;
wire fourthShift28;
wire fourthShift29;
wire fourthShift30;
wire fourthShift31;

wire zeroBit;
assign zeroBit = 1'b0;

//module MUX32_2x1(Y, I0, I1, S);

MUX1_2x1 mux_first_0(.Y(firstShift0), .I0(D[0]), .I1(zeroBit), .S(S[0]));
MUX1_2x1 mux_first_1(.Y(firstShift1), .I0(D[1]), .I1(D[0]), .S(S[0]));
MUX1_2x1 mux_first_2(.Y(firstShift2), .I0(D[2]), .I1(D[1]), .S(S[0]));
MUX1_2x1 mux_first_3(.Y(firstShift3), .I0(D[3]), .I1(D[2]), .S(S[0]));
MUX1_2x1 mux_first_4(.Y(firstShift4), .I0(D[4]), .I1(D[3]), .S(S[0]));
MUX1_2x1 mux_first_5(.Y(firstShift5), .I0(D[5]), .I1(D[4]), .S(S[0]));
MUX1_2x1 mux_first_6(.Y(firstShift6), .I0(D[6]), .I1(D[5]), .S(S[0]));
MUX1_2x1 mux_first_7(.Y(firstShift7), .I0(D[7]), .I1(D[6]), .S(S[0]));
MUX1_2x1 mux_first_8(.Y(firstShift8), .I0(D[8]), .I1(D[7]), .S(S[0]));
MUX1_2x1 mux_first_9(.Y(firstShift9), .I0(D[9]), .I1(D[8]), .S(S[0]));
MUX1_2x1 mux_first_10(.Y(firstShift10), .I0(D[10]), .I1(D[9]), .S(S[0]));
MUX1_2x1 mux_first_11(.Y(firstShift11), .I0(D[11]), .I1(D[10]), .S(S[0]));
MUX1_2x1 mux_first_12(.Y(firstShift12), .I0(D[12]), .I1(D[11]), .S(S[0]));
MUX1_2x1 mux_first_13(.Y(firstShift13), .I0(D[13]), .I1(D[12]), .S(S[0]));
MUX1_2x1 mux_first_14(.Y(firstShift14), .I0(D[14]), .I1(D[13]), .S(S[0]));
MUX1_2x1 mux_first_15(.Y(firstShift15), .I0(D[15]), .I1(D[14]), .S(S[0]));
MUX1_2x1 mux_first_16(.Y(firstShift16), .I0(D[16]), .I1(D[15]), .S(S[0]));
MUX1_2x1 mux_first_17(.Y(firstShift17), .I0(D[17]), .I1(D[16]), .S(S[0]));
MUX1_2x1 mux_first_18(.Y(firstShift18), .I0(D[18]), .I1(D[17]), .S(S[0]));
MUX1_2x1 mux_first_19(.Y(firstShift19), .I0(D[19]), .I1(D[18]), .S(S[0]));
MUX1_2x1 mux_first_20(.Y(firstShift20), .I0(D[20]), .I1(D[19]), .S(S[0]));
MUX1_2x1 mux_first_21(.Y(firstShift21), .I0(D[21]), .I1(D[20]), .S(S[0]));
MUX1_2x1 mux_first_22(.Y(firstShift22), .I0(D[22]), .I1(D[21]), .S(S[0]));
MUX1_2x1 mux_first_23(.Y(firstShift23), .I0(D[23]), .I1(D[22]), .S(S[0]));
MUX1_2x1 mux_first_24(.Y(firstShift24), .I0(D[24]), .I1(D[23]), .S(S[0]));
MUX1_2x1 mux_first_25(.Y(firstShift25), .I0(D[25]), .I1(D[24]), .S(S[0]));
MUX1_2x1 mux_first_26(.Y(firstShift26), .I0(D[26]), .I1(D[25]), .S(S[0]));
MUX1_2x1 mux_first_27(.Y(firstShift27), .I0(D[27]), .I1(D[26]), .S(S[0]));
MUX1_2x1 mux_first_28(.Y(firstShift28), .I0(D[28]), .I1(D[27]), .S(S[0]));
MUX1_2x1 mux_first_29(.Y(firstShift29), .I0(D[29]), .I1(D[28]), .S(S[0]));
MUX1_2x1 mux_first_30(.Y(firstShift30), .I0(D[30]), .I1(D[29]), .S(S[0]));
MUX1_2x1 mux_first_31(.Y(firstShift31), .I0(D[31]), .I1(D[30]), .S(S[0]));


MUX1_2x1 mux_second_0(.Y(secondShift0), .I0(firstShift0), .I1(zeroBit), .S(S[1]));
MUX1_2x1 mux_second_1(.Y(secondShift1), .I0(firstShift1), .I1(zeroBit), .S(S[1]));
MUX1_2x1 mux_second_2(.Y(secondShift2), .I0(firstShift2), .I1(firstShift0), .S(S[1]));
MUX1_2x1 mux_second_3(.Y(secondShift3), .I0(firstShift3), .I1(firstShift1), .S(S[1]));
MUX1_2x1 mux_second_4(.Y(secondShift4), .I0(firstShift4), .I1(firstShift2), .S(S[1]));
MUX1_2x1 mux_second_5(.Y(secondShift5), .I0(firstShift5), .I1(firstShift3), .S(S[1]));
MUX1_2x1 mux_second_6(.Y(secondShift6), .I0(firstShift6), .I1(firstShift4), .S(S[1]));
MUX1_2x1 mux_second_7(.Y(secondShift7), .I0(firstShift7), .I1(firstShift5), .S(S[1]));
MUX1_2x1 mux_second_8(.Y(secondShift8), .I0(firstShift8), .I1(firstShift6), .S(S[1]));
MUX1_2x1 mux_second_9(.Y(secondShift9), .I0(firstShift9), .I1(firstShift7), .S(S[1]));
MUX1_2x1 mux_second_10(.Y(secondShift10), .I0(firstShift10), .I1(firstShift8), .S(S[1]));
MUX1_2x1 mux_second_11(.Y(secondShift11), .I0(firstShift11), .I1(firstShift9), .S(S[1]));
MUX1_2x1 mux_second_12(.Y(secondShift12), .I0(firstShift12), .I1(firstShift10), .S(S[1]));
MUX1_2x1 mux_second_13(.Y(secondShift13), .I0(firstShift13), .I1(firstShift11), .S(S[1]));
MUX1_2x1 mux_second_14(.Y(secondShift14), .I0(firstShift14), .I1(firstShift12), .S(S[1]));
MUX1_2x1 mux_second_15(.Y(secondShift15), .I0(firstShift15), .I1(firstShift13), .S(S[1]));
MUX1_2x1 mux_second_16(.Y(secondShift16), .I0(firstShift16), .I1(firstShift14), .S(S[1]));
MUX1_2x1 mux_second_17(.Y(secondShift17), .I0(firstShift17), .I1(firstShift15), .S(S[1]));
MUX1_2x1 mux_second_18(.Y(secondShift18), .I0(firstShift18), .I1(firstShift16), .S(S[1]));
MUX1_2x1 mux_second_19(.Y(secondShift19), .I0(firstShift19), .I1(firstShift17), .S(S[1]));
MUX1_2x1 mux_second_20(.Y(secondShift20), .I0(firstShift20), .I1(firstShift18), .S(S[1]));
MUX1_2x1 mux_second_21(.Y(secondShift21), .I0(firstShift21), .I1(firstShift19), .S(S[1]));
MUX1_2x1 mux_second_22(.Y(secondShift22), .I0(firstShift22), .I1(firstShift20), .S(S[1]));
MUX1_2x1 mux_second_23(.Y(secondShift23), .I0(firstShift23), .I1(firstShift21), .S(S[1]));
MUX1_2x1 mux_second_24(.Y(secondShift24), .I0(firstShift24), .I1(firstShift22), .S(S[1]));
MUX1_2x1 mux_second_25(.Y(secondShift25), .I0(firstShift25), .I1(firstShift23), .S(S[1]));
MUX1_2x1 mux_second_26(.Y(secondShift26), .I0(firstShift26), .I1(firstShift24), .S(S[1]));
MUX1_2x1 mux_second_27(.Y(secondShift27), .I0(firstShift27), .I1(firstShift25), .S(S[1]));
MUX1_2x1 mux_second_28(.Y(secondShift28), .I0(firstShift28), .I1(firstShift26), .S(S[1]));
MUX1_2x1 mux_second_29(.Y(secondShift29), .I0(firstShift29), .I1(firstShift27), .S(S[1]));
MUX1_2x1 mux_second_30(.Y(secondShift30), .I0(firstShift30), .I1(firstShift28), .S(S[1]));
MUX1_2x1 mux_second_31(.Y(secondShift31), .I0(firstShift31), .I1(firstShift29), .S(S[1]));

MUX1_2x1 mux_third_0(.Y(thirdShift0), .I0(secondShift0), .I1(zeroBit), .S(S[2]));
MUX1_2x1 mux_third_1(.Y(thirdShift1), .I0(secondShift1), .I1(zeroBit), .S(S[2]));
MUX1_2x1 mux_third_2(.Y(thirdShift2), .I0(secondShift2), .I1(zeroBit), .S(S[2]));
MUX1_2x1 mux_third_3(.Y(thirdShift3), .I0(secondShift3), .I1(zeroBit), .S(S[2]));
MUX1_2x1 mux_third_4(.Y(thirdShift4), .I0(secondShift4), .I1(secondShift0), .S(S[2]));
MUX1_2x1 mux_third_5(.Y(thirdShift5), .I0(secondShift5), .I1(secondShift1), .S(S[2]));
MUX1_2x1 mux_third_6(.Y(thirdShift6), .I0(secondShift6), .I1(secondShift2), .S(S[2]));
MUX1_2x1 mux_third_7(.Y(thirdShift7), .I0(secondShift7), .I1(secondShift3), .S(S[2]));
MUX1_2x1 mux_third_8(.Y(thirdShift8), .I0(secondShift8), .I1(secondShift4), .S(S[2]));
MUX1_2x1 mux_third_9(.Y(thirdShift9), .I0(secondShift9), .I1(secondShift5), .S(S[2]));
MUX1_2x1 mux_third_10(.Y(thirdShift10), .I0(secondShift10), .I1(secondShift6), .S(S[2]));
MUX1_2x1 mux_third_11(.Y(thirdShift11), .I0(secondShift11), .I1(secondShift7), .S(S[2]));
MUX1_2x1 mux_third_12(.Y(thirdShift12), .I0(secondShift12), .I1(secondShift8), .S(S[2]));
MUX1_2x1 mux_third_13(.Y(thirdShift13), .I0(secondShift13), .I1(secondShift9), .S(S[2]));
MUX1_2x1 mux_third_14(.Y(thirdShift14), .I0(secondShift14), .I1(secondShift10), .S(S[2]));
MUX1_2x1 mux_third_15(.Y(thirdShift15), .I0(secondShift15), .I1(secondShift11), .S(S[2]));
MUX1_2x1 mux_third_16(.Y(thirdShift16), .I0(secondShift16), .I1(secondShift12), .S(S[2]));
MUX1_2x1 mux_third_17(.Y(thirdShift17), .I0(secondShift17), .I1(secondShift13), .S(S[2]));
MUX1_2x1 mux_third_18(.Y(thirdShift18), .I0(secondShift18), .I1(secondShift14), .S(S[2]));
MUX1_2x1 mux_third_19(.Y(thirdShift19), .I0(secondShift19), .I1(secondShift15), .S(S[2]));
MUX1_2x1 mux_third_20(.Y(thirdShift20), .I0(secondShift20), .I1(secondShift16), .S(S[2]));
MUX1_2x1 mux_third_21(.Y(thirdShift21), .I0(secondShift21), .I1(secondShift17), .S(S[2]));
MUX1_2x1 mux_third_22(.Y(thirdShift22), .I0(secondShift22), .I1(secondShift18), .S(S[2]));
MUX1_2x1 mux_third_23(.Y(thirdShift23), .I0(secondShift23), .I1(secondShift19), .S(S[2]));
MUX1_2x1 mux_third_24(.Y(thirdShift24), .I0(secondShift24), .I1(secondShift20), .S(S[2]));
MUX1_2x1 mux_third_25(.Y(thirdShift25), .I0(secondShift25), .I1(secondShift21), .S(S[2]));
MUX1_2x1 mux_third_26(.Y(thirdShift26), .I0(secondShift26), .I1(secondShift22), .S(S[2]));
MUX1_2x1 mux_third_27(.Y(thirdShift27), .I0(secondShift27), .I1(secondShift23), .S(S[2]));
MUX1_2x1 mux_third_28(.Y(thirdShift28), .I0(secondShift28), .I1(secondShift24), .S(S[2]));
MUX1_2x1 mux_third_29(.Y(thirdShift29), .I0(secondShift29), .I1(secondShift25), .S(S[2]));
MUX1_2x1 mux_third_30(.Y(thirdShift30), .I0(secondShift30), .I1(secondShift26), .S(S[2]));
MUX1_2x1 mux_third_31(.Y(thirdShift31), .I0(secondShift31), .I1(secondShift27), .S(S[2]));

MUX1_2x1 mux_fourth_0(.Y(fourthShift0), .I0(thirdShift0), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_1(.Y(fourthShift1), .I0(thirdShift1), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_2(.Y(fourthShift2), .I0(thirdShift2), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_3(.Y(fourthShift3), .I0(thirdShift3), .I1(zeroBit), .S(S[3])); //4th
MUX1_2x1 mux_fourth_4(.Y(fourthShift4), .I0(thirdShift4), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_5(.Y(fourthShift5), .I0(thirdShift5), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_6(.Y(fourthShift6), .I0(thirdShift6), .I1(zeroBit), .S(S[3]));
MUX1_2x1 mux_fourth_7(.Y(fourthShift7), .I0(thirdShift7), .I1(zeroBit), .S(S[3])); //8th
MUX1_2x1 mux_fourth_8(.Y(fourthShift8), .I0(thirdShift8), .I1(thirdShift0), .S(S[3]));
MUX1_2x1 mux_fourth_9(.Y(fourthShift9), .I0(thirdShift9), .I1(thirdShift1), .S(S[3]));
MUX1_2x1 mux_fourth_10(.Y(fourthShift10), .I0(thirdShift10), .I1(thirdShift2), .S(S[3]));
MUX1_2x1 mux_fourth_11(.Y(fourthShift11), .I0(thirdShift11), .I1(thirdShift3), .S(S[3]));
MUX1_2x1 mux_fourth_12(.Y(fourthShift12), .I0(thirdShift12), .I1(thirdShift4), .S(S[3]));
MUX1_2x1 mux_fourth_13(.Y(fourthShift13), .I0(thirdShift13), .I1(thirdShift5), .S(S[3]));
MUX1_2x1 mux_fourth_14(.Y(fourthShift14), .I0(thirdShift14), .I1(thirdShift6), .S(S[3]));
MUX1_2x1 mux_fourth_15(.Y(fourthShift15), .I0(thirdShift15), .I1(thirdShift7), .S(S[3]));
MUX1_2x1 mux_fourth_16(.Y(fourthShift16), .I0(thirdShift16), .I1(thirdShift8), .S(S[3]));
MUX1_2x1 mux_fourth_17(.Y(fourthShift17), .I0(thirdShift17), .I1(thirdShift9), .S(S[3]));
MUX1_2x1 mux_fourth_18(.Y(fourthShift18), .I0(thirdShift18), .I1(thirdShift10), .S(S[3]));
MUX1_2x1 mux_fourth_19(.Y(fourthShift19), .I0(thirdShift19), .I1(thirdShift11), .S(S[3]));
MUX1_2x1 mux_fourth_20(.Y(fourthShift20), .I0(thirdShift20), .I1(thirdShift12), .S(S[3]));
MUX1_2x1 mux_fourth_21(.Y(fourthShift21), .I0(thirdShift21), .I1(thirdShift13), .S(S[3]));
MUX1_2x1 mux_fourth_22(.Y(fourthShift22), .I0(thirdShift22), .I1(thirdShift14), .S(S[3]));
MUX1_2x1 mux_fourth_23(.Y(fourthShift23), .I0(thirdShift23), .I1(thirdShift15), .S(S[3]));
MUX1_2x1 mux_fourth_24(.Y(fourthShift24), .I0(thirdShift24), .I1(thirdShift16), .S(S[3]));
MUX1_2x1 mux_fourth_25(.Y(fourthShift25), .I0(thirdShift25), .I1(thirdShift17), .S(S[3]));
MUX1_2x1 mux_fourth_26(.Y(fourthShift26), .I0(thirdShift26), .I1(thirdShift18), .S(S[3]));
MUX1_2x1 mux_fourth_27(.Y(fourthShift27), .I0(thirdShift27), .I1(thirdShift19), .S(S[3]));
MUX1_2x1 mux_fourth_28(.Y(fourthShift28), .I0(thirdShift28), .I1(thirdShift20), .S(S[3]));
MUX1_2x1 mux_fourth_29(.Y(fourthShift29), .I0(thirdShift29), .I1(thirdShift21), .S(S[3]));
MUX1_2x1 mux_fourth_30(.Y(fourthShift30), .I0(thirdShift30), .I1(thirdShift22), .S(S[3]));
MUX1_2x1 mux_fourth_31(.Y(fourthShift31), .I0(thirdShift31), .I1(thirdShift23), .S(S[3]));

MUX1_2x1 mux_fifth_0(.Y(Y[0]), .I0(fourthShift0), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_1(.Y(Y[1]), .I0(fourthShift1), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_2(.Y(Y[2]), .I0(fourthShift2), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_3(.Y(Y[3]), .I0(fourthShift3), .I1(zeroBit), .S(S[4])); // 4
MUX1_2x1 mux_fifth_4(.Y(Y[4]), .I0(fourthShift4), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_5(.Y(Y[5]), .I0(fourthShift5), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_6(.Y(Y[6]), .I0(fourthShift6), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_7(.Y(Y[7]), .I0(fourthShift7), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_8(.Y(Y[8]), .I0(fourthShift8), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_9(.Y(Y[9]), .I0(fourthShift9), .I1(zeroBit), .S(S[4])); // 10
MUX1_2x1 mux_fifth_10(.Y(Y[10]), .I0(fourthShift10), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_11(.Y(Y[11]), .I0(fourthShift11), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_12(.Y(Y[12]), .I0(fourthShift12), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_13(.Y(Y[13]), .I0(fourthShift13), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_14(.Y(Y[14]), .I0(fourthShift14), .I1(zeroBit), .S(S[4]));
MUX1_2x1 mux_fifth_15(.Y(Y[15]), .I0(fourthShift15), .I1(zeroBit), .S(S[4])); //16
MUX1_2x1 mux_fifth_16(.Y(Y[16]), .I0(fourthShift16), .I1(fourthShift0), .S(S[4]));
MUX1_2x1 mux_fifth_17(.Y(Y[17]), .I0(fourthShift17), .I1(fourthShift1), .S(S[4]));
MUX1_2x1 mux_fifth_18(.Y(Y[18]), .I0(fourthShift18), .I1(fourthShift2), .S(S[4]));
MUX1_2x1 mux_fifth_19(.Y(Y[19]), .I0(fourthShift19), .I1(fourthShift3), .S(S[4]));
MUX1_2x1 mux_fifth_20(.Y(Y[20]), .I0(fourthShift20), .I1(fourthShift4), .S(S[4]));
MUX1_2x1 mux_fifth_21(.Y(Y[21]), .I0(fourthShift21), .I1(fourthShift5), .S(S[4]));
MUX1_2x1 mux_fifth_22(.Y(Y[22]), .I0(fourthShift22), .I1(fourthShift6), .S(S[4]));
MUX1_2x1 mux_fifth_23(.Y(Y[23]), .I0(fourthShift23), .I1(fourthShift7), .S(S[4]));
MUX1_2x1 mux_fifth_24(.Y(Y[24]), .I0(fourthShift24), .I1(fourthShift8), .S(S[4]));
MUX1_2x1 mux_fifth_25(.Y(Y[25]), .I0(fourthShift25), .I1(fourthShift9), .S(S[4]));
MUX1_2x1 mux_fifth_26(.Y(Y[26]), .I0(fourthShift26), .I1(fourthShift10), .S(S[4]));
MUX1_2x1 mux_fifth_27(.Y(Y[27]), .I0(fourthShift27), .I1(fourthShift11), .S(S[4]));
MUX1_2x1 mux_fifth_28(.Y(Y[28]), .I0(fourthShift28), .I1(fourthShift12), .S(S[4]));
MUX1_2x1 mux_fifth_29(.Y(Y[29]), .I0(fourthShift29), .I1(fourthShift13), .S(S[4]));
MUX1_2x1 mux_fifth_30(.Y(Y[30]), .I0(fourthShift30), .I1(fourthShift14), .S(S[4]));
MUX1_2x1 mux_fifth_31(.Y(Y[31]), .I0(fourthShift31), .I1(fourthShift15), .S(S[4]));


endmodule

