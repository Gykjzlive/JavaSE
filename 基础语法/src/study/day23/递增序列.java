package study.day23;

import java.util.Scanner;

/**
 对于一个字母矩阵，我们称矩阵中的一个递增序列是指在矩阵中找到两个字母，
 它们在同一行，同一列，或者在同一 45 度的斜线上，这两个字母从左向右看、或者从上向下看是递增的。

 例如，如下矩阵中
 LANN
 QIAO
 有LN、LN、AN、AN、IO、AO、LQ、AI、NO、NO、AQ、IN、AN 等 13 个
 递增序列。注意当两个字母是从左下到右上排列时，从左向右看和从上向下看
 是不同的顺序。

 对于下面的 30 行 50 列的矩阵，请问总共有多少个递增序列？（如果你把
 以下文字复制到文本文件中，请务必检查复制的内容是否与文档中的一致。在
 试题目录下有一个文件 inc.txt，内容与下面的文本相同。

 */
public class 递增序列 {
    public static String s[]={
            "VLPWJVVNNZSWFGHSFRBCOIJTPYNEURPIGKQGPSXUGNELGRVZAG",
            "SDLLOVGRTWEYZKKXNKIRWGZWXWRHKXFASATDWZAPZRNHTNNGQF",
            "ZGUGXVQDQAEAHOQEADMWWXFBXECKAVIGPTKTTQFWSWPKRPSMGA",
            "BDGMGYHAOPPRRHKYZCMFZEDELCALTBSWNTAODXYVHQNDASUFRL",
            "YVYWQZUTEPFSFXLTZBMBQETXGXFUEBHGMJKBPNIHMYOELYZIKH",
            "ZYZHSLTCGNANNXTUJGBYKUOJMGOGRDPKEUGVHNZJZHDUNRERBU",
            "XFPTZKTPVQPJEMBHNTUBSMIYEGXNWQSBZMHMDRZZMJPZQTCWLR",
            "ZNXOKBITTPSHEXWHZXFLWEMPZTBVNKNYSHCIQRIKQHFRAYWOPG",
            "MHJKFYYBQSDPOVJICWWGGCOZSBGLSOXOFDAADZYEOBKDDTMQPA",
            "VIDPIGELBYMEVQLASLQRUKMXSEWGHRSFVXOMHSJWWXHIBCGVIF",
            "GWRFRFLHAMYWYZOIQODBIHHRIIMWJWJGYPFAHZZWJKRGOISUJC",
            "EKQKKPNEYCBWOQHTYFHHQZRLFNDOVXTWASSQWXKBIVTKTUIASK",
            "PEKNJFIVBKOZUEPPHIWLUBFUDWPIDRJKAZVJKPBRHCRMGNMFWW",
            "CGZAXHXPDELTACGUWBXWNNZNDQYYCIQRJCULIEBQBLLMJEUSZP",
            "RWHHQMBIJWTQPUFNAESPZHAQARNIDUCRYQAZMNVRVZUJOZUDGS",
            "PFGAYBDEECHUXFUZIKAXYDFWJNSAOPJYWUIEJSCORRBVQHCHMR",
            "JNVIPVEMQSHCCAXMWEFSYIGFPIXNIDXOTXTNBCHSHUZGKXFECL",
            "YZBAIIOTWLREPZISBGJLQDALKZUKEQMKLDIPXJEPENEIPWFDLP",
            "HBQKWJFLSEXVILKYPNSWUZLDCRTAYUUPEITQJEITZRQMMAQNLN",
            "DQDJGOWMBFKAIGWEAJOISPFPLULIWVVALLIIHBGEZLGRHRCKGF",
            "LXYPCVPNUKSWCCGXEYTEBAWRLWDWNHHNNNWQNIIBUCGUJYMRYW",
            "CZDKISKUSBPFHVGSAVJBDMNPSDKFRXVVPLVAQUGVUJEXSZFGFQ",
            "IYIJGISUANRAXTGQLAVFMQTICKQAHLEBGHAVOVVPEXIMLFWIYI",
            "ZIIFSOPCMAWCBPKWZBUQPQLGSNIBFADUUJJHPAIUVVNWNWKDZB",
            "HGTEEIISFGIUEUOWXVTPJDVACYQYFQUCXOXOSSMXLZDQESHXKP",
            "FEBZHJAGIFGXSMRDKGONGELOALLSYDVILRWAPXXBPOOSWZNEAS",
            "VJGMAOFLGYIFLJTEKDNIWHJAABCASFMAKIENSYIZZSLRSUIPCJ",
            "BMQGMPDRCPGWKTPLOTAINXZAAJWCPUJHPOUYWNWHZAKCDMZDSR",
            "RRARTVHZYYCEDXJQNQAINQVDJCZCZLCQWQQIKUYMYMOVMNCBVY",
            "ABTCRRUXVGYLZILFLOFYVWFFBZNFWDZOADRDCLIRFKBFBHMAXX"
    };
    public static void main(String[] args) {
        char [][]data=new char[30][50];
        for (int i = 0; i < 30; i++) {
            data[i]=s[i].toCharArray();
        }
        int count=0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j <50 ; j++) {
                for (int k = 1; k <50 ; k++) {
                    //右边
                    if (j+k<50&&data[i][j+k]>data[i][j]){
                        count++;
                    }
                    //下方
                    if (i+k<30&&data[i+k][j]>data[i][j]){
                        count++;
                    }
                    //右下方
                    if (i+k<30&&j+k<50&&data[i+k][j+k]>data[i][j]){
                        count++;
                    }
                    //右上方
                    if (i-k>=0&&j+k<50&&data[i-k][j+k]>data[i][j]){
                        count++;
                    }
                    //左下方
                    if (i+k<30&&j-k>=0&&data[i+k][j-k]>data[i][j]){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
