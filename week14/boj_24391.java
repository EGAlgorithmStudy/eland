package week14;

import java.io.*;
import java.util.*;

public class boj_24391 {

	static boolean[] visited;
	static int[] group;
	static HashMap<Integer,ArrayList<Integer>> connect;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;

		connect = new HashMap<>();

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;

			//없으면 생성 있으면 추가
			connect.computeIfAbsent(start, key -> new ArrayList<>()).add(end);
			connect.computeIfAbsent(end, key -> new ArrayList<>()).add(start);

		}


		int[] lectures = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken())-1;
		}

		visited = new boolean[N];
		group = new int[N];

		int groupId = 0;
		for(int i = 0; i < N; i++) {
			if (!visited[i]) {
				dfs(i, groupId);
				groupId++;
			}
		}

		for (int i = 1; i < N; i++) {
			int nowLecture = lectures[i - 1];
			int nextLecutre = lectures[i];
			if (group[nowLecture] != group[nextLecutre]) {
				count++;
			}
		}


		System.out.println(count);
	}

	public static void dfs(int nowLectuere, int groupId) {
		visited[nowLectuere] = true;
		group[nowLectuere] = groupId;

		for (int nextLecture : connect.getOrDefault(nowLectuere, new ArrayList<>())) {
			if (!visited[nextLecture]) {
				dfs(nextLecture, groupId);
			}
		}
	}
}
