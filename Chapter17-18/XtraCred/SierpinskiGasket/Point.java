	public class Point
	{
		private int x;
		private int y;

		public Point(int xc, int yc)
		{
			x = xc;
			y = yc;
		}

		public int getX()
		{
			return x;
		}

		public int getY()
		{
			return y;
		}

		public boolean equals(Object o)
		{
			Point c = (Point)o;
			return (c.x == x && c.y == y);
		}
	}

