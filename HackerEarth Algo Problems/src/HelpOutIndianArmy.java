import java.util.*;
 
public class HelpOutIndianArmy
{
 
	static class coords implements Comparable<coords>
	{
		Long x_coord, y_coord;
		coords(long x_coord,long y_coord)
		{
			this.x_coord=x_coord;
			this.y_coord=y_coord;
		}
		public int compareTo(coords obj) {
			return x_coord.compareTo(obj.x_coord);
		}
	}
 
	public static void main(String[] args)
	{
 
		Scanner sc = new Scanner(System.in);
 
		int check_pts =sc.nextInt();
		long startPos = sc.nextLong();
		long endPos = sc.nextLong();
 
		coords[] DefendedArea = new coords[check_pts];
		for(int i=0;i<check_pts;i++)
		{
			long x_coord = sc.nextLong();
			long p = sc.nextLong();
			DefendedArea[i] = new coords(x_coord-p,x_coord+p);
		}
 
		Arrays.sort(DefendedArea);
		ArrayList<coords> b = new ArrayList<coords>();
 
		long c = DefendedArea[0].x_coord;
		long d = DefendedArea[0].y_coord;
 
		//merging the defended segments if any
		for(int i=1;i<check_pts;i++)
		{
			if(DefendedArea[i].x_coord<=d)
				d = Math.max(d, DefendedArea[i].y_coord);
			else
			{
				b.add(new coords(c,d));
				c = DefendedArea[i].x_coord;
				d = DefendedArea[i].y_coord;
			}
		}
		b.add(new coords(c,d));
		int i;
		long result = 0;
		for(i=0;i<b.size();i++)
		{
			if(startPos>=endPos)
			{
				startPos = endPos;
				break;
			}
			
			if(b.get(i).x_coord<=startPos && startPos<=b.get(i).y_coord)
				startPos = b.get(i).y_coord;
			else if(startPos<=b.get(i).x_coord && endPos>=b.get(i).y_coord)
			{
				result+=b.get(i).x_coord-startPos;
				startPos = b.get(i).y_coord;
 
			}
			else if(startPos<=b.get(i).x_coord && endPos>=b.get(i).x_coord &&  endPos<=b.get(i).y_coord)
			{
				result+=b.get(i).x_coord-startPos;
				startPos = endPos;
			}
			
			else if(startPos<=b.get(i).x_coord && endPos<=b.get(i).x_coord)
			{
				result+=endPos-startPos;
				startPos = endPos;
			}
		}
		
		if(startPos<endPos)
			result+=endPos-startPos;
		System.out.println(result);
		
		sc.close();
 
	}
}
