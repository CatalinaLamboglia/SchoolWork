// Name: rc_add_sub_32.v
// Module: RC_ADD_SUB_32
//
// Output: Y : Output 32-bit
//         CO : Carry Out
//         
//
// Input: A : 32-bit input
//        B : 32-bit input
//        SnA : if SnA=0 it is add, subtraction otherwise
//
// Notes: 32-bit adder / subtractor implementaiton.
// 
//
// Revision History:
//
// Version	Date		Who		email			note
//------------------------------------------------------------------------------------------
//  1.0     Sep 10, 2014	Kaushik Patra	kpatra@sjsu.edu		Initial creation
//------------------------------------------------------------------------------------------
`include "prj_definition.v"

module RC_ADD_SUB_64(Y, CO, A, B, SnA);
// output list
output [63:0] Y;
output CO;
// input list
input [63:0] A;
input [63:0] B;
input SnA;

wire [63:0] Y;
wire CO;
//wire [63:0] B;
//wire [63:0] A;

wire B0;
wire B1;
wire B2;
wire B3;
wire B4;
wire B5;
wire B6;
wire B7;
wire B8;
wire B9;
wire B10;
wire B11;
wire B12;
wire B13;
wire B14;
wire B15;
wire B16;
wire B17;
wire B18;
wire B19;
wire B20;
wire B21;
wire B22;
wire B23;
wire B24;
wire B25;
wire B26;
wire B27;
wire B28;
wire B29;
wire B30;
wire B31;
wire B32;
wire B33;
wire B34;
wire B35;
wire B36;
wire B37;
wire B38;
wire B39;
wire B40;
wire B41;
wire B42;
wire B43;
wire B44;
wire B45;
wire B46;
wire B47;
wire B48;
wire B49;
wire B50;
wire B51;
wire B52;
wire B53;
wire B54;
wire B55;
wire B56;
wire B57;
wire B58;
wire B59;
wire B60;
wire B61;
wire B62;
wire B63;

wire CO0;
wire CO1;
wire CO2;
wire CO3;
wire CO4;
wire CO5;
wire CO6;
wire CO7;
wire CO8;
wire CO9;
wire CO10;
wire CO11;
wire CO12;
wire CO13;
wire CO14;
wire CO15;
wire CO16;
wire CO17;
wire CO18;
wire CO19;
wire CO20;
wire CO21;
wire CO22;
wire CO23;
wire CO24;
wire CO25;
wire CO26;
wire CO27;
wire CO28;
wire CO29;
wire CO30;
wire CO31;
wire CO32;
wire CO33;
wire CO34;
wire CO35;
wire CO36;
wire CO37;
wire CO38;
wire CO39;
wire CO40;
wire CO41;
wire CO42;
wire CO43;
wire CO44;
wire CO45;
wire CO46;
wire CO47;
wire CO48;
wire CO49;
wire CO50;
wire CO51;
wire CO52;
wire CO53;
wire CO54;
wire CO55;
wire CO56;
wire CO57;
wire CO58;
wire CO59;
wire CO60;
wire CO61;
wire CO62;
wire CO63;

xor xor0(B0, SnA, B[0]);
xor xor1(B1, SnA, B[1]);
xor xor2(B2, SnA, B[2]);
xor xor3(B3, SnA, B[3]);
xor xor4(B4, SnA, B[4]);
xor xor5(B5, SnA, B[5]);
xor xor6(B6, SnA, B[6]);
xor xor7(B7, SnA, B[7]);
xor xor8(B8, SnA, B[8]);
xor xor9(B9, SnA, B[9]);
xor xor10(B10, SnA, B[10]);
xor xor11(B11, SnA, B[11]);
xor xor12(B12, SnA, B[12]);
xor xor13(B13, SnA, B[13]);
xor xor14(B14, SnA, B[14]);
xor xor15(B15, SnA, B[15]);
xor xor16(B16, SnA, B[16]);
xor xor17(B17, SnA, B[17]);
xor xor18(B18, SnA, B[18]);
xor xor19(B19, SnA, B[19]);
xor xor20(B20, SnA, B[20]);
xor xor21(B21, SnA, B[21]);
xor xor22(B22, SnA, B[22]);
xor xor23(B23, SnA, B[23]);
xor xor24(B24, SnA, B[24]);
xor xor25(B25, SnA, B[25]);
xor xor26(B26, SnA, B[26]);
xor xor27(B27, SnA, B[27]);
xor xor28(B28, SnA, B[28]);
xor xor29(B29, SnA, B[29]);
xor xor30(B30, SnA, B[30]);
xor xor31(B31, SnA, B[31]);
xor xor32(B32, SnA, B[32]);
xor xor33(B33, SnA, B[33]);
xor xor34(B34, SnA, B[34]);
xor xor35(B35, SnA, B[35]);
xor xor36(B36, SnA, B[36]);
xor xor37(B37, SnA, B[37]);
xor xor38(B38, SnA, B[38]);
xor xor39(B39, SnA, B[39]);
xor xor40(B40, SnA, B[40]);
xor xor41(B41, SnA, B[41]);
xor xor42(B42, SnA, B[42]);
xor xor43(B43, SnA, B[43]);
xor xor44(B44, SnA, B[44]);
xor xor45(B45, SnA, B[45]);
xor xor46(B46, SnA, B[46]);
xor xor47(B47, SnA, B[47]);
xor xor48(B48, SnA, B[48]);
xor xor49(B49, SnA, B[49]);
xor xor50(B50, SnA, B[50]);
xor xor51(B51, SnA, B[51]);
xor xor52(B52, SnA, B[52]);
xor xor53(B53, SnA, B[53]);
xor xor54(B54, SnA, B[54]);
xor xor55(B55, SnA, B[55]);
xor xor56(B56, SnA, B[56]);
xor xor57(B57, SnA, B[57]);
xor xor58(B58, SnA, B[58]);
xor xor59(B59, SnA, B[59]);
xor xor60(B60, SnA, B[60]);
xor xor61(B61, SnA, B[61]);
xor xor62(B62, SnA, B[62]);
xor xor63(B63, SnA, B[63]);

FULL_ADDER fa_inst_0(.S(Y[0]), .CO(CO0), .A(A[0]), .B(B0), .CI(SnA));
FULL_ADDER fa_inst_1(.S(Y[1]), .CO(CO1), .A(A[1]), .B(B1), .CI(CO0));
FULL_ADDER fa_inst_2(.S(Y[2]), .CO(CO2), .A(A[2]), .B(B2), .CI(CO1));
FULL_ADDER fa_inst_3(.S(Y[3]), .CO(CO3), .A(A[3]), .B(B3), .CI(CO2));
FULL_ADDER fa_inst_4(.S(Y[4]), .CO(CO4), .A(A[4]), .B(B4), .CI(CO3));
FULL_ADDER fa_inst_5(.S(Y[5]), .CO(CO5), .A(A[5]), .B(B5), .CI(CO4));
FULL_ADDER fa_inst_6(.S(Y[6]), .CO(CO6), .A(A[6]), .B(B6), .CI(CO5));
FULL_ADDER fa_inst_7(.S(Y[7]), .CO(CO7), .A(A[7]), .B(B7), .CI(CO6));
FULL_ADDER fa_inst_8(.S(Y[8]), .CO(CO8), .A(A[8]), .B(B8), .CI(CO7));
FULL_ADDER fa_inst_9(.S(Y[9]), .CO(CO9), .A(A[9]), .B(B9), .CI(CO8));
FULL_ADDER fa_inst_10(.S(Y[10]), .CO(CO10), .A(A[10]), .B(B10), .CI(CO9));
FULL_ADDER fa_inst_11(.S(Y[11]), .CO(CO11), .A(A[11]), .B(B11), .CI(CO10));
FULL_ADDER fa_inst_12(.S(Y[12]), .CO(CO12), .A(A[12]), .B(B12), .CI(CO11));
FULL_ADDER fa_inst_13(.S(Y[13]), .CO(CO13), .A(A[13]), .B(B13), .CI(CO12));
FULL_ADDER fa_inst_14(.S(Y[14]), .CO(CO14), .A(A[14]), .B(B14), .CI(CO13));
FULL_ADDER fa_inst_15(.S(Y[15]), .CO(CO15), .A(A[15]), .B(B15), .CI(CO14));
FULL_ADDER fa_inst_16(.S(Y[16]), .CO(CO16), .A(A[16]), .B(B16), .CI(CO15));
FULL_ADDER fa_inst_17(.S(Y[17]), .CO(CO17), .A(A[17]), .B(B17), .CI(CO16));
FULL_ADDER fa_inst_18(.S(Y[18]), .CO(CO18), .A(A[18]), .B(B18), .CI(CO17));
FULL_ADDER fa_inst_19(.S(Y[19]), .CO(CO19), .A(A[19]), .B(B19), .CI(CO18));
FULL_ADDER fa_inst_20(.S(Y[20]), .CO(CO20), .A(A[20]), .B(B20), .CI(CO19));
FULL_ADDER fa_inst_21(.S(Y[21]), .CO(CO21), .A(A[21]), .B(B21), .CI(CO20));
FULL_ADDER fa_inst_22(.S(Y[22]), .CO(CO22), .A(A[22]), .B(B22), .CI(CO21));
FULL_ADDER fa_inst_23(.S(Y[23]), .CO(CO23), .A(A[23]), .B(B23), .CI(CO22));
FULL_ADDER fa_inst_24(.S(Y[24]), .CO(CO24), .A(A[24]), .B(B24), .CI(CO23));
FULL_ADDER fa_inst_25(.S(Y[25]), .CO(CO25), .A(A[25]), .B(B25), .CI(CO24));
FULL_ADDER fa_inst_26(.S(Y[26]), .CO(CO26), .A(A[26]), .B(B26), .CI(CO25));
FULL_ADDER fa_inst_27(.S(Y[27]), .CO(CO27), .A(A[27]), .B(B27), .CI(CO26));
FULL_ADDER fa_inst_28(.S(Y[28]), .CO(CO28), .A(A[28]), .B(B28), .CI(CO27));
FULL_ADDER fa_inst_29(.S(Y[29]), .CO(CO29), .A(A[29]), .B(B29), .CI(CO28));
FULL_ADDER fa_inst_30(.S(Y[30]), .CO(CO30), .A(A[30]), .B(B30), .CI(CO29));
FULL_ADDER fa_inst_31(.S(Y[31]), .CO(CO31), .A(A[31]), .B(B31), .CI(CO30));
FULL_ADDER fa_inst_32(.S(Y[32]), .CO(CO32), .A(A[32]), .B(B32), .CI(CO31));
FULL_ADDER fa_inst_33(.S(Y[33]), .CO(CO33), .A(A[33]), .B(B33), .CI(CO32));
FULL_ADDER fa_inst_34(.S(Y[34]), .CO(CO34), .A(A[34]), .B(B34), .CI(CO33));
FULL_ADDER fa_inst_35(.S(Y[35]), .CO(CO35), .A(A[35]), .B(B35), .CI(CO34));
FULL_ADDER fa_inst_36(.S(Y[36]), .CO(CO36), .A(A[36]), .B(B36), .CI(CO35));
FULL_ADDER fa_inst_37(.S(Y[37]), .CO(CO37), .A(A[37]), .B(B37), .CI(CO36));
FULL_ADDER fa_inst_38(.S(Y[38]), .CO(CO38), .A(A[38]), .B(B38), .CI(CO37));
FULL_ADDER fa_inst_39(.S(Y[39]), .CO(CO39), .A(A[39]), .B(B39), .CI(CO38));
FULL_ADDER fa_inst_40(.S(Y[40]), .CO(CO40), .A(A[40]), .B(B40), .CI(CO39));
FULL_ADDER fa_inst_41(.S(Y[41]), .CO(CO41), .A(A[41]), .B(B41), .CI(CO40));
FULL_ADDER fa_inst_42(.S(Y[42]), .CO(CO42), .A(A[42]), .B(B42), .CI(CO41));
FULL_ADDER fa_inst_43(.S(Y[43]), .CO(CO43), .A(A[43]), .B(B43), .CI(CO42));
FULL_ADDER fa_inst_44(.S(Y[44]), .CO(CO44), .A(A[44]), .B(B44), .CI(CO43));
FULL_ADDER fa_inst_45(.S(Y[45]), .CO(CO45), .A(A[45]), .B(B45), .CI(CO44));
FULL_ADDER fa_inst_46(.S(Y[46]), .CO(CO46), .A(A[46]), .B(B46), .CI(CO45));
FULL_ADDER fa_inst_47(.S(Y[47]), .CO(CO47), .A(A[47]), .B(B47), .CI(CO46));
FULL_ADDER fa_inst_48(.S(Y[48]), .CO(CO48), .A(A[48]), .B(B48), .CI(CO47));
FULL_ADDER fa_inst_49(.S(Y[49]), .CO(CO49), .A(A[49]), .B(B49), .CI(CO48));
FULL_ADDER fa_inst_50(.S(Y[50]), .CO(CO50), .A(A[50]), .B(B50), .CI(CO49));
FULL_ADDER fa_inst_51(.S(Y[51]), .CO(CO51), .A(A[51]), .B(B51), .CI(CO50));
FULL_ADDER fa_inst_52(.S(Y[52]), .CO(CO52), .A(A[52]), .B(B52), .CI(CO51));
FULL_ADDER fa_inst_53(.S(Y[53]), .CO(CO53), .A(A[53]), .B(B53), .CI(CO52));
FULL_ADDER fa_inst_54(.S(Y[54]), .CO(CO54), .A(A[54]), .B(B54), .CI(CO53));
FULL_ADDER fa_inst_55(.S(Y[55]), .CO(CO55), .A(A[55]), .B(B55), .CI(CO54));
FULL_ADDER fa_inst_56(.S(Y[56]), .CO(CO56), .A(A[56]), .B(B56), .CI(CO55));
FULL_ADDER fa_inst_57(.S(Y[57]), .CO(CO57), .A(A[57]), .B(B57), .CI(CO56));
FULL_ADDER fa_inst_58(.S(Y[58]), .CO(CO58), .A(A[58]), .B(B58), .CI(CO57));
FULL_ADDER fa_inst_59(.S(Y[59]), .CO(CO59), .A(A[59]), .B(B59), .CI(CO58));
FULL_ADDER fa_inst_60(.S(Y[60]), .CO(CO60), .A(A[60]), .B(B60), .CI(CO59));
FULL_ADDER fa_inst_61(.S(Y[61]), .CO(CO61), .A(A[61]), .B(B61), .CI(CO60));
FULL_ADDER fa_inst_62(.S(Y[62]), .CO(CO62), .A(A[62]), .B(B62), .CI(CO61));
FULL_ADDER fa_inst_63(.S(Y[63]), .CO(CO63), .A(A[63]), .B(B63), .CI(CO62));

assign CO = CO63;

endmodule

module RC_ADD_SUB_32(Y, CO, A, B, SnA);
// output list
output [`DATA_INDEX_LIMIT:0] Y;
output CO;
// input list
input [`DATA_INDEX_LIMIT:0] A;
input [`DATA_INDEX_LIMIT:0] B;
input SnA;

wire [`DATA_INDEX_LIMIT:0] Y;
wire CO;



wire B0;
wire B1;
wire B2;
wire B3;
wire B4;
wire B5;
wire B6;
wire B7;
wire B8;
wire B9;
wire B10;
wire B11;
wire B12;
wire B13;
wire B14;
wire B15;
wire B16;
wire B17;
wire B18;
wire B19;
wire B20;
wire B21;
wire B22;
wire B23;
wire B24;
wire B25;
wire B26;
wire B27;
wire B28;
wire B29;
wire B30;
wire B31;

wire CO0;
wire CO1;
wire CO2;
wire CO3;
wire CO4;
wire CO5;
wire CO6;
wire CO7;
wire CO8;
wire CO9;
wire CO10;
wire CO11;
wire CO12;
wire CO13;
wire CO14;
wire CO15;
wire CO16;
wire CO17;
wire CO18;
wire CO19;
wire CO20;
wire CO21;
wire CO22;
wire CO23;
wire CO24;
wire CO25;
wire CO26;
wire CO27;
wire CO28;
wire CO29;
wire CO30;
wire CO31;

xor xor0(B0, SnA, B[0]);
xor xor1(B1, SnA, B[1]);
xor xor2(B2, SnA, B[2]);
xor xor3(B3, SnA, B[3]);
xor xor4(B4, SnA, B[4]);
xor xor5(B5, SnA, B[5]);
xor xor6(B6, SnA, B[6]);
xor xor7(B7, SnA, B[7]);
xor xor8(B8, SnA, B[8]);
xor xor9(B9, SnA, B[9]);
xor xor10(B10, SnA, B[10]);
xor xor11(B11, SnA, B[11]);
xor xor12(B12, SnA, B[12]);
xor xor13(B13, SnA, B[13]);
xor xor14(B14, SnA, B[14]);
xor xor15(B15, SnA, B[15]);
xor xor16(B16, SnA, B[16]);
xor xor17(B17, SnA, B[17]);
xor xor18(B18, SnA, B[18]);
xor xor19(B19, SnA, B[19]);
xor xor20(B20, SnA, B[20]);
xor xor21(B21, SnA, B[21]);
xor xor22(B22, SnA, B[22]);
xor xor23(B23, SnA, B[23]);
xor xor24(B24, SnA, B[24]);
xor xor25(B25, SnA, B[25]);
xor xor26(B26, SnA, B[26]);
xor xor27(B27, SnA, B[27]);
xor xor28(B28, SnA, B[28]);
xor xor29(B29, SnA, B[29]);
xor xor30(B30, SnA, B[30]);
xor xor31(B31, SnA, B[31]);


FULL_ADDER fa_inst_0(.S(Y[0]), .CO(CO0), .A(A[0]), .B(B0), .CI(SnA));
FULL_ADDER fa_inst_1(.S(Y[1]), .CO(CO1), .A(A[1]), .B(B1), .CI(CO0));
FULL_ADDER fa_inst_2(.S(Y[2]), .CO(CO2), .A(A[2]), .B(B2), .CI(CO1));
FULL_ADDER fa_inst_3(.S(Y[3]), .CO(CO3), .A(A[3]), .B(B3), .CI(CO2));
FULL_ADDER fa_inst_4(.S(Y[4]), .CO(CO4), .A(A[4]), .B(B4), .CI(CO3));
FULL_ADDER fa_inst_5(.S(Y[5]), .CO(CO5), .A(A[5]), .B(B5), .CI(CO4));
FULL_ADDER fa_inst_6(.S(Y[6]), .CO(CO6), .A(A[6]), .B(B6), .CI(CO5));
FULL_ADDER fa_inst_7(.S(Y[7]), .CO(CO7), .A(A[7]), .B(B7), .CI(CO6));
FULL_ADDER fa_inst_8(.S(Y[8]), .CO(CO8), .A(A[8]), .B(B8), .CI(CO7));
FULL_ADDER fa_inst_9(.S(Y[9]), .CO(CO9), .A(A[9]), .B(B9), .CI(CO8));
FULL_ADDER fa_inst_10(.S(Y[10]), .CO(CO10), .A(A[10]), .B(B10), .CI(CO9));
FULL_ADDER fa_inst_11(.S(Y[11]), .CO(CO11), .A(A[11]), .B(B11), .CI(CO10));
FULL_ADDER fa_inst_12(.S(Y[12]), .CO(CO12), .A(A[12]), .B(B12), .CI(CO11));
FULL_ADDER fa_inst_13(.S(Y[13]), .CO(CO13), .A(A[13]), .B(B13), .CI(CO12));
FULL_ADDER fa_inst_14(.S(Y[14]), .CO(CO14), .A(A[14]), .B(B14), .CI(CO13));
FULL_ADDER fa_inst_15(.S(Y[15]), .CO(CO15), .A(A[15]), .B(B15), .CI(CO14));
FULL_ADDER fa_inst_16(.S(Y[16]), .CO(CO16), .A(A[16]), .B(B16), .CI(CO15));
FULL_ADDER fa_inst_17(.S(Y[17]), .CO(CO17), .A(A[17]), .B(B17), .CI(CO16));
FULL_ADDER fa_inst_18(.S(Y[18]), .CO(CO18), .A(A[18]), .B(B18), .CI(CO17));
FULL_ADDER fa_inst_19(.S(Y[19]), .CO(CO19), .A(A[19]), .B(B19), .CI(CO18));
FULL_ADDER fa_inst_20(.S(Y[20]), .CO(CO20), .A(A[20]), .B(B20), .CI(CO19));
FULL_ADDER fa_inst_21(.S(Y[21]), .CO(CO21), .A(A[21]), .B(B21), .CI(CO20));
FULL_ADDER fa_inst_22(.S(Y[22]), .CO(CO22), .A(A[22]), .B(B22), .CI(CO21));
FULL_ADDER fa_inst_23(.S(Y[23]), .CO(CO23), .A(A[23]), .B(B23), .CI(CO22));
FULL_ADDER fa_inst_24(.S(Y[24]), .CO(CO24), .A(A[24]), .B(B24), .CI(CO23));
FULL_ADDER fa_inst_25(.S(Y[25]), .CO(CO25), .A(A[25]), .B(B25), .CI(CO24));
FULL_ADDER fa_inst_26(.S(Y[26]), .CO(CO26), .A(A[26]), .B(B26), .CI(CO25));
FULL_ADDER fa_inst_27(.S(Y[27]), .CO(CO27), .A(A[27]), .B(B27), .CI(CO26));
FULL_ADDER fa_inst_28(.S(Y[28]), .CO(CO28), .A(A[28]), .B(B28), .CI(CO27));
FULL_ADDER fa_inst_29(.S(Y[29]), .CO(CO29), .A(A[29]), .B(B29), .CI(CO28));
FULL_ADDER fa_inst_30(.S(Y[30]), .CO(CO30), .A(A[30]), .B(B30), .CI(CO29));
FULL_ADDER fa_inst_31(.S(Y[31]), .CO(CO31), .A(A[31]), .B(B31), .CI(CO30));

assign CO = CO31;

endmodule

