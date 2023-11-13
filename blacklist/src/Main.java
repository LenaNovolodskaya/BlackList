import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main extends BlackListFilterImp {
    public static void main(String[] args) throws IOException {
        // Записываем запрещённые слова
        File filebl = new File("blacklist.txt");
        if(!filebl.exists())
            return;
        Scanner inbl = new Scanner(filebl);
        Set<String> blackList = new HashSet<>();
        while (inbl.hasNext()) {
            String str = inbl.nextLine();
            blackList.add(str);
        }

        // Записываем комментарии
        File filec = new File("comments.txt");
        if(!filec.exists())
            return;
        Scanner inc = new Scanner(filec);
        List<String> comments = new ArrayList<>();
        while (inc.hasNext()) {
            String str = inc.nextLine();
            comments.add(str);
        }

        // Фильтруем комментарии
        BlackListFilter filteredComments = new BlackListFilterImp();
        filteredComments.filterComments(comments, blackList);
    }

}