`timescale 1ns/1ps

module barrel_shifter_tb;
wire [31:0] Y_R;
wire [31:0] Y_L;
wire [31:0] Y_Shifter;
wire [31:0] Y_32;

reg [31:0] D_L;
reg [31:0] D_R;
reg [31:0] D_S;
reg [31:0] D_32;
reg [4:0] S;
reg [31:0] S_32;
reg LnR; // if == 0 then shift right


//module SHIFT32_L(Y,D,S);
//module SHIFT32(Y,D,S, LnR);
//module BARREL_SHIFTER32(Y,D,S, LnR);
SHIFT32_L shift_left(.Y(Y_L), .D(D_L), .S(S));
SHIFT32_R shift_right(.Y(Y_R), .D(D_R), .S(S));
BARREL_SHIFTER32 shifter(.Y(Y_Shifter), .D(D_S), .S(S), .LnR(LnR));
SHIFT32 shifter32(.Y(Y_32), .D(D_32), .S(S_32), .LnR(LnR));

initial 
begin
D_R=50; D_L=50; D_S = 50; D_32 = 50; S=1; S_32 = 1; LnR = 0;
#10 D_R=500; D_L=500; D_S = 500; D_32 = 500; S=2; S_32 = 2; LnR = 0;
#10 D_R=2000; D_L=2000; D_S = 2000; D_32 = 2000; S=1; S_32 = 1; LnR = 1;
#10 D_R=2; D_L=2; D_S = 2; D_32 = 2; S=20; S_32 = 20; LnR = 1;
#10 D_R=2; D_L=2; D_S = 2; D_32 = 2; S=45; S_32 = 45; LnR = 0;
#10 D_R=200; D_L=200; D_S = 200; D_32 = 200; S=15; S_32 = 15; LnR = 0;
#5 ;
end

endmodule