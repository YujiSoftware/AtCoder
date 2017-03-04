import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@Test
	public void 入力例1() throws Exception {
		String input = "10 10 20 4 9" + System.lineSeparator() +
				"##########" + System.lineSeparator() +
				"###.....##" + System.lineSeparator() +
				"##...##..#" + System.lineSeparator() +
				"#...####.#" + System.lineSeparator() +
				"#...######" + System.lineSeparator() +
				"#...######" + System.lineSeparator() +
				"#...######" + System.lineSeparator() +
				"#...######" + System.lineSeparator() +
				"#...######" + System.lineSeparator() +
				"##########" + System.lineSeparator() +
				"2" + System.lineSeparator() +
				"3 9 10000 5" + System.lineSeparator() +
				"3 3 4 1";
		String output = "ULRLULLLDLL-DDR-RRRR";

		assertIO(input, output);
	}

	@Test
	public void 入力例2() throws Exception {
		String input = "50 50 2500 23 16" + System.lineSeparator() +
				"##################################################" + System.lineSeparator() +
				"###......#########.#.###.##.###.################.#" + System.lineSeparator() +
				"########.#########.#.###.##.###.################.#" + System.lineSeparator() +
				"########.#.....###.#........###.################.#" + System.lineSeparator() +
				"########.##.##.###................##############.#" + System.lineSeparator() +
				"###...................##.######.#.##############.#" + System.lineSeparator() +
				"###########.###.#..#..##.######.#.##############.#" + System.lineSeparator() +
				"###########.#...#..#...............#############.#" + System.lineSeparator() +
				"###########.#.#...............#.....##...........#" + System.lineSeparator() +
				"###########.###.#.#.#..#......#....###.###########" + System.lineSeparator() +
				"###########.#####.#.##.#........#..###.###########" + System.lineSeparator() +
				"###########.####................#..###.###########" + System.lineSeparator() +
				"###########.####....#........#..#.........########" + System.lineSeparator() +
				"#########...............................##########" + System.lineSeparator() +
				"##.######.######...................###..##########" + System.lineSeparator() +
				"#..######.#................#.#......##..##########" + System.lineSeparator() +
				"#..######.#..#.#........................##########" + System.lineSeparator() +
				"#.........................#..#......#...##########" + System.lineSeparator() +
				"#..........#..............#..#......#...##########" + System.lineSeparator() +
				"#..........#.....#......................##########" + System.lineSeparator() +
				"#...#..#...#.................#......#...##########" + System.lineSeparator() +
				"#..##..#.#.#........................#...##########" + System.lineSeparator() +
				"#..........##.......................#....#########" + System.lineSeparator() +
				"##.#.#.#.#.#...................#....#.......######" + System.lineSeparator() +
				"####.#.........................#....#...###.######" + System.lineSeparator() +
				"####.....................................##.######" + System.lineSeparator() +
				"####.........##.....#..........#..#.##...##.######" + System.lineSeparator() +
				"####.......................#......#.#.......######" + System.lineSeparator() +
				"#.##......##.#....................#.#....#########" + System.lineSeparator() +
				"#...................................#....#########" + System.lineSeparator() +
				"#.##.##...##.##.#........................#########" + System.lineSeparator() +
				"#.##.##...##.##.....................#....#########" + System.lineSeparator() +
				"#.##..................#.............#...##########" + System.lineSeparator() +
				"#....##....#........................#...##########" + System.lineSeparator() +
				"#...................................#...##########" + System.lineSeparator() +
				"#.......................................##########" + System.lineSeparator() +
				"##.#..##....###.##.#....................##########" + System.lineSeparator() +
				"####..##..#.###.##.#.##...#........#.#..##########" + System.lineSeparator() +
				"####..##..#.###.##.#.##...#.............##########" + System.lineSeparator() +
				"###.......#........#.##...#.#...####.#.###########" + System.lineSeparator() +
				"####..##..#####.####.##...#.#...#.........########" + System.lineSeparator() +
				"####..##..#####.####.##...#.#...#.####.##.########" + System.lineSeparator() +
				"####..##..#####.####......#.....#.###.....########" + System.lineSeparator() +
				"#####.###.#####.####..#.#.............###.########" + System.lineSeparator() +
				"#####.###.#####..###..####.##.#.#.#######.########" + System.lineSeparator() +
				"#####.###.#####..###..####.##.#.#.################" + System.lineSeparator() +
				"#.....###.####....##..####.#......################" + System.lineSeparator() +
				"#########..................##.......##############" + System.lineSeparator() +
				"####################.#..........#.################" + System.lineSeparator() +
				"##################################################" + System.lineSeparator() +
				"128" + System.lineSeparator() +
				"36 6 33421 59" + System.lineSeparator() +
				"28 14 59990 74" + System.lineSeparator() +
				"21 15 91235 96" + System.lineSeparator() +
				"35 21 27683 71" + System.lineSeparator() +
				"20 11 11576 6" + System.lineSeparator() +
				"30 18 1583 87" + System.lineSeparator() +
				"6 4 21368 56" + System.lineSeparator() +
				"9 16 96637 100" + System.lineSeparator() +
				"26 11 21283 33" + System.lineSeparator() +
				"31 8 20294 33" + System.lineSeparator() +
				"2 21 65091 29" + System.lineSeparator() +
				"19 22 18039 17" + System.lineSeparator() +
				"5 33 98990 34" + System.lineSeparator() +
				"24 18 6500 60" + System.lineSeparator() +
				"14 10 26823 20" + System.lineSeparator() +
				"25 28 85792 28" + System.lineSeparator() +
				"47 18 537 36" + System.lineSeparator() +
				"26 23 60156 38" + System.lineSeparator() +
				"28 15 17810 17" + System.lineSeparator() +
				"20 39 28088 77" + System.lineSeparator() +
				"33 31 49621 37" + System.lineSeparator() +
				"20 32 83255 24" + System.lineSeparator() +
				"4 49 17499 96" + System.lineSeparator() +
				"31 9 93800 85" + System.lineSeparator() +
				"18 35 75782 37" + System.lineSeparator() +
				"24 25 61216 36" + System.lineSeparator() +
				"23 35 11322 33" + System.lineSeparator() +
				"6 5 84247 43" + System.lineSeparator() +
				"12 26 97308 40" + System.lineSeparator() +
				"6 6 7020 93" + System.lineSeparator() +
				"25 44 48412 4" + System.lineSeparator() +
				"6 15 30741 93" + System.lineSeparator() +
				"28 40 60392 6" + System.lineSeparator() +
				"23 28 50081 46" + System.lineSeparator() +
				"5 27 27989 38" + System.lineSeparator() +
				"23 32 91705 72" + System.lineSeparator() +
				"12 23 26710 59" + System.lineSeparator() +
				"28 17 36863 94" + System.lineSeparator() +
				"20 36 12665 77" + System.lineSeparator() +
				"17 12 69103 43" + System.lineSeparator() +
				"19 2 22817 20" + System.lineSeparator() +
				"18 38 27069 40" + System.lineSeparator() +
				"10 25 89918 76" + System.lineSeparator() +
				"32 28 7871 14" + System.lineSeparator() +
				"35 24 40156 17" + System.lineSeparator() +
				"32 16 50330 35" + System.lineSeparator() +
				"35 16 94626 5" + System.lineSeparator() +
				"17 33 2103 94" + System.lineSeparator() +
				"48 34 87848 82" + System.lineSeparator() +
				"19 21 52841 86" + System.lineSeparator() +
				"2 9 47976 39" + System.lineSeparator() +
				"46 17 10653 70" + System.lineSeparator() +
				"4 15 28399 40" + System.lineSeparator() +
				"5 30 85741 4" + System.lineSeparator() +
				"16 20 66310 36" + System.lineSeparator() +
				"13 27 79008 52" + System.lineSeparator() +
				"25 13 53822 71" + System.lineSeparator() +
				"8 18 96550 51" + System.lineSeparator() +
				"39 34 29271 54" + System.lineSeparator() +
				"38 24 92830 30" + System.lineSeparator() +
				"38 34 90137 86" + System.lineSeparator() +
				"48 18 82174 6" + System.lineSeparator() +
				"24 9 96186 3" + System.lineSeparator() +
				"7 18 21405 19" + System.lineSeparator() +
				"16 23 53528 2" + System.lineSeparator() +
				"31 31 8980 90" + System.lineSeparator() +
				"23 14 6256 21" + System.lineSeparator() +
				"49 24 57192 21" + System.lineSeparator() +
				"30 38 29651 33" + System.lineSeparator() +
				"16 24 80144 66" + System.lineSeparator() +
				"39 19 71496 10" + System.lineSeparator() +
				"26 38 22365 82" + System.lineSeparator() +
				"16 27 94591 4" + System.lineSeparator() +
				"30 19 13375 52" + System.lineSeparator() +
				"48 22 13906 29" + System.lineSeparator() +
				"45 21 15200 100" + System.lineSeparator() +
				"17 24 73814 1" + System.lineSeparator() +
				"5 15 89249 49" + System.lineSeparator() +
				"43 31 12710 19" + System.lineSeparator() +
				"16 21 89488 33" + System.lineSeparator() +
				"17 29 70865 55" + System.lineSeparator() +
				"33 20 71412 100" + System.lineSeparator() +
				"19 40 96591 32" + System.lineSeparator() +
				"8 30 6866 40" + System.lineSeparator() +
				"34 3 68501 20" + System.lineSeparator() +
				"24 28 99184 74" + System.lineSeparator() +
				"31 38 60999 70" + System.lineSeparator() +
				"8 22 88203 87" + System.lineSeparator() +
				"21 19 55945 64" + System.lineSeparator() +
				"14 18 46530 68" + System.lineSeparator() +
				"33 27 90347 100" + System.lineSeparator() +
				"44 31 40042 4" + System.lineSeparator() +
				"8 16 25939 91" + System.lineSeparator() +
				"44 28 17446 7" + System.lineSeparator() +
				"43 32 30346 61" + System.lineSeparator() +
				"22 2 16138 39" + System.lineSeparator() +
				"17 32 23668 8" + System.lineSeparator() +
				"20 29 3455 11" + System.lineSeparator() +
				"21 38 10036 59" + System.lineSeparator() +
				"14 19 80874 52" + System.lineSeparator() +
				"24 23 25439 55" + System.lineSeparator() +
				"29 8 7661 89" + System.lineSeparator() +
				"32 26 86161 51" + System.lineSeparator() +
				"22 27 18200 72" + System.lineSeparator() +
				"40 10 13922 31" + System.lineSeparator() +
				"8 23 58303 73" + System.lineSeparator() +
				"24 40 57936 38" + System.lineSeparator() +
				"27 11 14252 62" + System.lineSeparator() +
				"37 19 18676 93" + System.lineSeparator() +
				"17 21 46494 63" + System.lineSeparator() +
				"20 14 87223 9" + System.lineSeparator() +
				"39 39 9764 8" + System.lineSeparator() +
				"20 3 74043 69" + System.lineSeparator() +
				"47 16 76510 86" + System.lineSeparator() +
				"20 31 74695 46" + System.lineSeparator() +
				"29 26 78237 53" + System.lineSeparator() +
				"28 13 12037 81" + System.lineSeparator() +
				"38 19 65664 100" + System.lineSeparator() +
				"40 13 62357 39" + System.lineSeparator() +
				"27 13 95311 27" + System.lineSeparator() +
				"34 13 2537 69" + System.lineSeparator() +
				"46 6 94570 43" + System.lineSeparator() +
				"23 5 65255 8" + System.lineSeparator() +
				"2 25 93842 49" + System.lineSeparator() +
				"18 28 29560 48" + System.lineSeparator() +
				"12 24 60028 98" + System.lineSeparator() +
				"36 30 40774 28" + System.lineSeparator() +
				"24 42 57689 22";
		String output = "LDUDURRLDLRURDLURRU-DR--RRURDLRDRDRUULUDRRUDDD-DLLDRDLRD-R-UU-R--L-ULURDU-DULRL-RUDUUR-URUURUD-RDLLLRRDUURLDURLD-R-LDLURUULRULRLDUURLRDLDLUULLLU-DL-DLD-U-DLLURDR-RUD-URRUDLU-RUU-URUDL-DLLUDRUUURUU--RRL-DR-RDUUUULURDRU--UDLLRLDRU-DLLU-DDLLUD-RRDRLD-UDDRDDUUDLUR--D-L-RUUUDR--LL-LUURLUD--UDRDDL--UDL-RRR-L-LRUDUDD----D-DRDLU-UU-RRD-DL-RR-LDDR-UDRRRUU-DDR-U-L-UDUULRDRDLLUD--D--LRUU-UUULU-DDDDLDRUDLDRURUURLDRL-L-RRDRD-LL-D-LD--RDRLDULLLD-L-L-URRURLURL-L--DR--RD-LLULRUDRLLUDDRUUDD-URLRRRLUD-URLD-UDDUURLLUUR-LDULDRRDRD-LD-LRL-R-D-DLDRDD-LLLLDDDULL--LLDDLU--DU---LLDRUL--LDD-UL-L-ULUDUDDULD-R-LUR-LDDDRDL-LULLULLDUULU-DRRU--DDUUDLDRU-U--UUURDD-----URDLUDRDULU-L-U-D-LUUURRLUDD-R-UL-DUD-LLRRUULRU-D-R-L--RDRLLLRLDUDDLU--DULLD-LLLLDRUUURURRR-RDUDLUD--U-R-ULRLR-UL-U-RDDRRRRRLR-RURRUD--UUDRULDLRLURLD-R-RL-ULLL-DLRDD-U-DUR-L--DU-DLDR-RLRL-LLDLRDRU-LRLDDRD-U-L-RRD---ULD-RRDULLURL-RLDUR-DD-DLRDU---LUDRR-L-U-U--UD-UD--URUR--LUD-DUDR--URLD-DD---DU-RRUUUULLDUL-L-UUDUDDRURLRU-R-DR-DLUDRL--LRLDDL---DDULLUUUDLRUUDLRDUULDURRULURUL-DRDULDDR---U-URDRRUURLR-L-LDRLURR-R-UU-R-URDRD-U-RLLDD--L-RD-DRRRRU-L-LRR-UDLURLULRLRRDUDRL-RDLD-URRL-L-DURLU-UDDDLLLLLDUUU-ULUURRUR-UU-RDD--URL-UDDDDU-DULURUURD-DUL-LR--ULDLL-DLD--RULD-DUULRUDLD-DLDRL-DU--R-RRDDDRLRD-LDDRRR-R-RDDUULL-DRDUDLL-RDL--UUUUDLRR-L-RDRDRD-UDRUR--DLULURR-UD-LLRLRDL-LR-DUUUDLDD-ULURLRR--R--UDUDUDLDR-RUD-DRU-DDRLR--U-LLD-RDU-U-RRULDLUDRDUL-RDUULD-R--LRRRLULDD--UUU-D-RLDD-LLULL-L--R--LRDR-RRD-U-LUUURRRD--R-URRDU-RRRULURUR-RLULLL-UUUURLLDR--RLLDU-RRUL-DR-LURUDDURL-DRDR-R-UULDLR-RDURD---LLRUULLUDDRULLRRRRUURDDD-DLUDRURLLUDLLRL-DDR--L-URLRU--UR-LDRUURUDDU-DUD-UDDLL-RU-R-DDLDURLRUULULDURR-RRRDRUUDDRLRLLDDDULULRU--DRRLRRDL--ULLRRRLDUULULR-URULLLRDURR-LU-LURLUDLUURU-RU--D-DD-RD-LLRRU-RDUUR-RRDDRLDD---LLRRLL-LDDUUR-ULRUDRLRULDLDUDU-ULLLL--LRRUDDDDRLL-RDRUR-UULDDUL-L--DLLLDU-UDDULUR--D-LDDRDUU-L---RDRULRU-DDLRRLRU-URDRUURR-DD-RURULL-LLDL-DDRULLULL--LRURLUL--D-D-DDLUURUDUDURUL-DDDRLRDUU-RD-UU-URRL-RULDU-R--ULLRURRDRLLDLL-D-LUL-D-UULRU-DUUDLDULUL-DRRRRLRDRURDDRUU-RD--UDRUULLLL-L-RLDRRUD-ULRLURDD-LLDDLL--URLUUDULUDLUDR--DLDDLLLRRURLD-R--DR-U-U-LURUURDD-RRU--LDRLUUDLRUUUULRRRU-LULDD-UDULDLUU---D-LUUDRR-U-ULUU-LL-R-URLLD-RDRRUL-LLRU-R--DUDDU-R--RRULLUU-DRRLDLDDRUR--UD-R-DRDDL-LDRDLRRDUDUUDRDLU--D--RRD-DULR-R--ULUU-DRLUULLR-UD-LRL-LULRRDDU-LUDUDU-UR--R-RLLLULDD-L-URRDDDULDUU-RURUDLUUDUURDDDR-LRL--R-L-DU-DDD-DURDRRLDLLL-UULL-RLRRL--URUUL-RDR-RDLDDLDURRLDLDUUD-ULU-DR--RLR-LRDLRDDRLUL-RUR-U--URU-D-LD--RRURRRR-UDLU--LLRDDUDL---DUURRDUD-RUD-UURDLLD-RLD";

		assertIO(input, output);
	}

	private void assertIO(String input, String output) throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Main.main(new String[0]);

		Assert.assertThat(out.toString(), is(output + System.lineSeparator()));
	}
}
