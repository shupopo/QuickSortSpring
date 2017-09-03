import java.util.List;

import com.quicksort.business.domain.User;

public class QuickSortControllerTest {
	
//	List<User> users = userRepository.findAll();
//	int recordSize = users.size();
//	User[] user = new User[recordSize];
//	
//	List<Integer>scoreList = new ArrayList<Integer>();
//	for(int i=0;i<recordSize;i++){
//		user[i] = users.get(i);
//		scoreList.add(user[i].getScore());
//	}
//	List<Integer> scoreListNoDuplication = new ArrayList<Integer>(new HashSet<>(scoreList));
//	int[] scoreArray = toArr(scoreListNoDuplication);
//	
//	
//    
//	List<User> result = new ArrayList<User>();//Listはインターフェースなのでインスタンスを生成できない
//	for(int i=0;i<recordSize;i++){
//		result.add(i, userRepository.findByScoreLike(numArray[i]));
//	}

	
//	private static int[] toArr(List<Integer> list){
//  // List<Integer> -> int[]
//  int l = list.size();
//  int[] arr = new int[l];
//  Iterator<Integer> iter = list.iterator();
//  for (int i=0;i<l;i++) arr[i] = iter.next();
//  return arr;
//}  
	
//	@Override
//	public void displayUserList(List<User> list) {
//		List<User> userList = list;
//			System.out.println("ID"+" : "+"名前"+" : "+"スコア"+" : "+"性別");
//			for(int i=0;i<userList.size();i++){
//				User user = userList.get(i);
//				System.out.println(user.getId()+" : "+user.getName()+" : "+user.getScore()+" : "+user.getSex());
//			}
	
	/**
	 * SQLクエリを使わずにスコアのリストを取得する方法
	 */
//	List<User> users = dao.getAll();
//	int recordSize = users.size();
//	User[] user = new User[recordSize];
//	List<Integer>scoreList = new ArrayList<Integer>();
//	for(int i=0;i<recordSize;i++){
//		user[i] = users.get(i);
//		scoreList.add(user[i].getScore());
//	}
//	List<Integer> scoreListNotDuplicated = new ArrayList<Integer>(new HashSet<>(scoreList));
//	int[] scoreArray = toArr(scoreListNotDuplicated);
//
//	}

}
