class Main {

	public static void main(String[] args) throws Exception {
		System.out.println(func(func(func(20))));
	}

	private static long func(long n) {
		return (long) Math.floor((n * n + 4) / 8.0);
	}
}
