package com.quicksort.commandline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.quicksort.business.domain.User;
import com.quicksort.business.repository.UserRepository;
import com.quicksort.business.repository.Impl.UserDataDaoImpl;
import com.quicksort.business.service.SortService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CommandLineController implements CommandLineRunner {

	@Autowired
	private SortService sortService;

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	UserDataDaoImpl dao;

	@PostConstruct
	public void init() {
		dao = new UserDataDaoImpl(entityManager);
	}

	private Scanner scanner = new Scanner(System.in);

	@Override
	public void run(String... arg0) throws Exception {
		boolean loopFlag = true;
		while (loopFlag) {
			String line = "-----------------------------------";
			System.out.println(line);
			System.out.println("操作メニュー");
			System.out.println("[0]ソート実行 [1]プロフィール閲覧 [2]プロフィール登録 [3]プロフィール編集");
			System.out.println(line);
			int input = scanner.nextInt();
			switch (input) {
			case 0:
				List<User> result = sortService.createSortedUserList();
				System.out.println("ソート後のデータを表示します。");
				sortService.displayUserList(result);
				break;
			case 1:
				System.out.println("ソート前のデータを表示します。");
				List<User> userList = dao.getAll();
				sortService.displayUserList(userList);
				break;
			case 2:
				sortService.registProfile();
				break;
			case 3:
				sortService.editProfile();
				break;
			default:
				System.out.println("0〜3までの数値を入力してください。");
				break;
			}
		}
	}
}
