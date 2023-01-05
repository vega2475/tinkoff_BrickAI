import java.util.Arrays;

/**
made in Russia
 */

public class Main {
    public static void main(String[] args) {
        String text = "- Прошу садиться.\n" +
                "Мари Лоран опустилась в глубокое кожаное кресло.\n" +
                "Пока профессор Керн вскрывал конверт и читал письмо, она бегло осмотрела кабинет.\n" +
                "Какая мрачная комната! Но заниматься здесь хорошо: ничто не отвлекает внимания. Лампа с глухим абажуром освещает только письменный стол, заваленный книгами, рукописями, корректурными оттисками. Глаз едва различает солидную мебель черного дуба. Темные обои, темные драпри. В полумраке поблескивает только золото тисненых переплетов в тяжелых шкафах. Длинный маятник старинных стенных часов движется размеренно и плавно.\n" +
                "Переведя взгляд на Керна, Лоран невольно улыбнулась: сам профессор целиком соответствовал стилю кабинета. Будто вырубленная из дуба, тяжеловесная, суровая фигура Керна казалась частью меблировки. Большие очки в черепаховой оправе напоминали два циферблата часов. Как маятники, двигались его глаза серо-пепельного цвета, переходя со строки на строку письма. Прямоугольный нос, прямой разрез глаз, рта и квадратный, выдающийся вперед подбородок придавали лицу вид стилизованной декоративной маски, вылепленной скульптором-кубистом.\n" +
                "\"Камин украшать такой маской\", - подумала Лоран.";
        int weight = 74;

        solve(text, weight);
    }

    public static void solve(String text, int weight) {
        String[] arrOfParagraph = text.split("\n");
        String[] arrOfWords = text.split("[. ]");
        System.out.println(Arrays.toString(arrOfWords));
        StringBuilder sb = new StringBuilder();
        int redString = 6;
        int space = 1;

        for (int i = 0; i < arrOfParagraph.length; i++) {
            String[] arrOfWords1 = arrOfParagraph[i].split("[. ]");
            int quantityOfSymbols = 6;
            int quantityOfWords = 0;
            int quantityOfSymbolsInEachParagraph = arrOfParagraph[i].length();
            if(arrOfParagraph[i].length() > weight) {
                for (int j = 0; quantityOfSymbols < weight - arrOfWords1[arrOfWords1.length - 1].length(); j++) {
                    quantityOfSymbols += arrOfWords1[j].length() + 1; //подсчет кол-ва символов для каждой строки включая красную строку (ее пишем как 6 пробелов)
                    quantityOfWords++;
                }
            }
            else{
                sb.append("      ").append(arrOfParagraph[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}