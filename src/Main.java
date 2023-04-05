import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		Scanner sc = new Scanner(System.in);

		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.print("명령어 >> ");
			String cmd = sc.nextLine().trim();

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (cmd.equals("exit")) {
				break;
			}

			if (cmd.equals("article write")) {
				System.out.println("==게시물 작성==");
				int id = lastArticleId + 1;
				String regDate = Util.getNowDateTimeStr();
				System.out.print("제목 ) ");
				String title = sc.nextLine();
				System.out.print("내용 ) ");
				String body = sc.nextLine();

				Article article = new Article(id, regDate, title, body);
				articles.add(article);

				lastArticleId++;
				System.out.println(id + "번 글이 등록되었습니다(" + regDate + ")");
			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다");
					continue;
				}
				System.out.println("번호   /   제목  ");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.printf("%d     /     %s   \n", article.id, article.title);
				}
			}

			else {
				System.out.println("명령어를 확인해주세요. 입력된 명령어 : " + cmd);
			}
		}

		System.out.println("==프로그램 종료==");
		sc.close();

	}
}

class Util {
	/** 포맷팅 현재 날짜/시간 반환 Str */
	public static String getNowDateTimeStr() {
		// 현재 날짜/시간
		LocalDateTime now = LocalDateTime.now();
		// 포맷팅
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		// 포맷팅 현재 날짜/시간 출력

		return formatedNow;
	}
}

class Article {
	int id;
	String regDate;
	String title;
	String body;

	public Article(int id, String regDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
	}

}
