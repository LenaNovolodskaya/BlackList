import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BlackListFilterImp implements BlackListFilter {
    /**
     * Функция, удаляющаа из всех накопленных комментариев нежелательные.
     * @param comments список всех комментариев
     * @param blackList список запрещённых слов
     */
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        // Создаем новый список для хранения отфильтрованных комментариев
        List<String> filteredComments = new ArrayList<>();

        // Перебираем каждый комментарий
        for (String comment : comments) {
            // Разбиваем комментарий на слова, удаляя пунктуацию
            String[] words = comment.split("\\s+|\\p{Punct}");

            // Проверяем, содержит ли комментарий запрещенные слова
            boolean containsBlacklistedWord = false;
            for (String word : words) {
                if (blackList.contains(word)) {
                    containsBlacklistedWord = true;
                    break;
                }
            }

            /* Если комментарий не содержит запрещенных слов,
            добавляем его в отфильтрованный список */
            if (!containsBlacklistedWord) {
                filteredComments.add(comment);
            }
        }

        // Заменяем исходный список отфильтрованным
        comments.clear();
        comments.addAll(filteredComments);

        // Выводим отфильтрованный список
        for (int i = 0; i < filteredComments.size(); i++) {
            System.out.println(filteredComments.get(i));
        }
    }
}