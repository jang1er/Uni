library IEEE;
use IEEE.std_logic_1164.all;

entity MUX is 
    port(
        a, b, sel   : in std_logic;
        f           : out std_logic);
    end MUX;
