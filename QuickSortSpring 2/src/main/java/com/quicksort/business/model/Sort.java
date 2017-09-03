package com.quicksort.business.model;

public interface Sort {

	void sortNumArray(int[] array);// メソッド名sortを数列をソートすることを明確にするためsortNumArrayに変更

}
// bubble sort merge sortも作る
// sort対象をDBのテーブルに登録し、結果を別のテーブルに登録する
// userモデルに名前と点数、性別のテーブルを作ってソート後の結果を別のテーブルに登録する
// userの登録、アップデート、一覧表示してセレクト 削除する機能を作成する crud = create, read, update, delete