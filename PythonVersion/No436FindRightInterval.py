class Solution(object):
    def findRightInterval(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[int]
        """
        length = len(intervals)
        sortlist = []
        for i in range(length):
            sortlist.append((intervals[i].start, i))
         
        sorted(sortlist, key=lambda x: x[0]);
        out = []
        for i in range(length):
            left = 0
            right = length-1
            val = float('inf')
            while left <= right:
                mid = int((right + left)/2)
                if sortlist[mid][0] >= intervals[i].end:
                    val = min(val, sortlist[mid][1])
                    right = mid-1
                else:
                    left = mid+1
            out.append([val, -1][val == float('inf')])
        return out    
        
        
class Interval(object):
     def __init__(self, s=0, e=0):
        self.start = s
        self.end = e
        
test = [Interval(1,4), Interval(2,3),Interval(3,4),Interval(4,6)]
solu = Solution()
out = solu.findRightInterval(test)
for i in out:
    print(i, end=" ")

