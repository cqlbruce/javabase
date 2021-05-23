package com.sun.al.leetcode;

import java.util.Arrays;

/*
*There are two sorted arrays nums1 and nums2 of size m and n respectively.
*Find the median of the two sorted arrays.
*The overall run time complexity should be O(log (m+n)).
*You may assume nums1 and nums2 cannot be both empty.
*nums1 = [1, 3]
*nums2 = [2]
*The median is 2.0
*
*nums1 = [1, 2]
*nums2 = [3, 4]
*The median is (2 + 3)/2 = 2.5
*
* */
public class MedianSorted {

    public static void main(String[] args) {

//        int[] nums1 = {2 , 5};
//        int[] nums2 = {3 , 9};[]
//[1]
        int[] nums1 = {100001};
        int[] nums2 = {100000};
        System.out.println(findMedianSortedArraysOne(nums1,nums2));
    }

    //s1 : 暴力破解 -- 垃圾 异常狼狈的解法
    //合并数组，取中值
    public static double findMedianSortedArraysOne(int[] nums1 , int[] nums2){
        int index = nums1.length + nums2.length;
        int n1=0 , n2=0 ;
        int i = 0 ;
        int[] nums = new int[index];
        int a = 0 ;
        int b = 0 ;

        while (i<index){
            a=-1890890890;
            b=-1890890890;
            if (n1<nums1.length&&nums1.length>0)
                a = nums1[n1];
            if (n2<nums2.length&&nums2.length>0)
                b = nums2[n2];


            if(nums2.length==0&&nums1.length>0){
                nums[i]=a ;
                n1++;
            }else if(a<b&&a!=-1890890890){
                nums[i]=a ;
                n1++;
            }else if (a>b&&b==-1890890890 ){
                nums[i]=a ;
                n1++;
            }else if(a == b && a != -1890890890){
                nums[i]=b;
                nums[++i]=b;
                n1++;
                n2++;
            }else if(b != -1890890890){
                nums[i]=b;
                n2++;
            }
            i++ ;
        }
        if(nums.length<2){
            return nums[0];
        }else if (index%2==0){
            double t1=nums[index/2-1];
            double t2=nums[index/2];
            return (t1+t2)/2;
        }else {
            return nums[index/2];
        }
    }

    // s2:分治法 时间效率 0(log(m+n))
    // s3:
    // s4:
    /*
    * 算法思路
    *主要是使用了分治的思想，想法和上一道题目Reverse Pairs 差不多。
    * 1. 题目要我求两个已经排列好的序列A与B的中位数，两个序列的长度分别是m与n，既求两个序列中第k=（m+n）2个数。
    *  2. 我们假设p和q分别是A和B的中位数（这个很容易求），
    * 然后比较p和q的大小，若p < q，说明A中P之前的数字都不是两个序列的中位数。
    * 我们就可以A面半部分的数字“抛弃”掉。现在的问题就变成了求剩下的数字中第kp个数字了。
    * 3. 我们通过这样每次都扔掉其中一个序列的一半的数字，最后就可以很快得求得问题的解。
    * 4. 我们要注意几个边界问题。（1）如果A或者B为空，只需返回A[k1]或者B[k1]。
    * （2）如果k为1，则返回A[0]与B[0]中比较小的那个数。（3）如果A[k/21]=B[k/21]，
    * 则随便返回其中一个。
    *
    * */
    public static double findMedianSortedArraysTwo(int[] nums1 , int[] nums2) {




        return 0.0;
    }

    /*
    * 参考 : https://blog.csdn.net/xiaoguaihai/article/details/81264148
    * s3
    * 代码1：时间复杂度O(m+n)
    *
    * 合并数组 ， 然后取中值
    * */
    public static double findMedianSortedArraysThree(int[] nums1 , int[] nums2) {
        int i = 0 ;
        int j = 0 ;
        int len = nums1.length + nums2.length;
        int k = len / 2 ; //只求一半的值就好了，因为找中值
        int prev = 0 ;//前面一个值
        int cur = 0 ;
        while (i < nums1.length && j < nums2.length && i + j < k ){
            prev = cur ;
            if(nums1[i] < nums2[j]){
                cur = nums1[i];
                i++;
            }else {
                cur = nums2[j];
                j++;
            }
        }
        while (i < nums1.length && i+j <= k ){
            prev = cur;
            cur = nums1[i];
            i++;
        }
        while (j < nums2.length && i+j <= k ){
            prev=cur;
            cur = nums2[j];
            j++;
        }
        if(len % 2 == 0){
            return (prev + cur) / 2.0;
        }else {
            return cur ;
        }
    }

    /*
     * 参考 : https://blog.csdn.net/xiaoguaihai/article/details/81264148
     *
     * 代码2：时间复杂度为O(log (m+n))
     *
     * 我们把A数组分成2部分，左边部分有i个数，右边有m-i个数，如下所示：
     *    left_A             |        right_A
     *A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     *同样，把B数组分成2部分，左边部分有j个数，右边有n-j个数，如下所示：
          left_B             |        right_B
     *B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     *我们让 i + j = (m + n) / 2，则我们就将2个数组分成了左右个数相等的2部分，如下所示：
          left_part          |        right_part
     *A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     *B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     *当A[i-1] < B[j] 并且 A[i] > B[j-1]时，中位数就找到了。当m+n为奇数时，中位数就是左边最大的数；当m+n为偶数时，中位数就是左边最大的数和右边最小的数的平均值。
     *所以问题就转换成：找到这样一个满足条件的i的值。
     *当A[i-1] > B[j]时，表示i的值偏大了，这个时候就要减小i的值，相应的j的值就要增大；
     *当A[i] < B[j-1]时，表示i的值偏小了，这个时候就要增大i的值，相应的j的值就要减小；
     *如此一直调整i的值，直到找到满足条件的i的值，则找到了中位数。
     * */
    /*
    *一、建模 ， 找双数组的中位数
    *二、找好边界条件
    * */
    public static double findMedianSortedArraysFour(int[] nums1 , int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        //保证m<n,避免j出现负数
        if(m>n){
            int[] tempArray = nums1;
            nums1 = nums2;
            nums2 = tempArray;
            int temp = m ;
            m = n ;
            n = temp ;
        }

        int halfLen = (m + n + 1) / 2 ;
        int iMin = 0 ;
        int iMax = m ;
        while (iMin <= iMax){
            int i = (iMin + iMax) / 2 ;
            int j = halfLen - i ;
            if (i < m && nums1[i] < nums2[j - 1]){//i的值偏小
                iMin = i + 1 ;
            }else if(i > 0 && nums1[i-1] > nums2[j]){//i的值偏大
                iMax = i - 1 ;
            }else { // i 的值正好
                int maxLeft = 0 ;
                if (i == 0){
                    maxLeft = nums2[j - 1];
                }else if(j == 0){
                    maxLeft = nums1[i -  1];
                }else {
                    maxLeft = Math.max(nums1[i - 1] , nums2[j - 1]);
                }
                //如果总数是奇数，则中位数是左半部分最大的数;否则为左边最大和右边最小数的平均值
                if ((m + n) % 2 == 1){
                    return maxLeft;
                }
                int minRight = 0 ;
                if (i == m){
                    minRight = nums2[j];
                }else if (j == n){
                    minRight = nums1[i];
                }else {
                    minRight = Math.min(nums1[i] , nums2[j]);
                }
                return (maxLeft + minRight)/2.0;
            }
        }
        return 0.0 ;
    }


    /*
    * https://www.cnblogs.com/grandyang/p/4465932.html
    *
    * s5:
    * 这道题让我们求两个有序数组的中位数，而且限制了时间复杂度为 O(log (m+n))，看到这个时间复杂度，
    * 自然而然的想到了应该使用二分查找法来求解。但是这道题被定义为 Hard 也是有其原因的，
    * 难就难在要在两个未合并的有序数组之间使用二分法，如果这道题只有一个有序数组，让求中位数的话，
    * 估计就是个 Easy 题。对于这道题来说，可以将两个有序数组混合起来成为一个有序数组再做吗，图样图森破，
    * 这个时间复杂度限制的就是告诉你金坷垃别想啦。还是要用二分法，而且是在两个数组之间使用，感觉很高端啊。
    * 回顾一下中位数的定义，如果某个有序数组长度是奇数，那么其中位数就是最中间那个，如果是偶数，
    * 那么就是最中间两个数字的平均值。这里对于两个有序数组也是一样的，假设两个有序数组的长度分别为m和n，
    * 由于两个数组长度之和 m+n 的奇偶不确定，因此需要分情况来讨论，对于奇数的情况，直接找到最中间的数即可，
    * 偶数的话需要求最中间两个数的平均值。为了简化代码，不分情况讨论，使用一个小 trick，分别找第 (m+n+1) / 2 个，
    * 和 (m+n+2) / 2 个，然后求其平均值即可，这对奇偶数均适用。若 m+n 为奇数的话，那么其实 (m+n+1) / 2 和 (m+n+2) / 2
    * 的值相等，相当于两个相同的数字相加再除以2，还是其本身。
    * 好，这里需要定义一个函数来在两个有序数组中找到第K个元素，下面重点来看如何实现找到第K个元素。
    * 首先，为了避免拷贝产生新的数组从而增加时间复杂度，使用两个变量i和j分别来标记数组 nums1 和 nums2 的起始位置。
    * 然后来处理一些 corner cases，比如当某一个数组的起始位置大于等于其数组长度时，说明其所有数字均已经被淘汰了，
    * 相当于一个空数组了，那么实际上就变成了在另一个数组中找数字，直接就可以找出来了。还有就是如果 K=1 的话，
    * 只要比较 nums1 和 nums2 的起始位置i和j上的数字就可以了。难点就在于一般的情况怎么处理？因为需要在两个
    * 有序数组中找到第K个元素，为了加快搜索的速度，可以使用二分法，那么对谁二分呢，数组么？其实要对K二分，
    * 意思是需要分别在 nums1 和 nums2 中查找第 K/2 个元素，注意这里由于两个数组的长度不定，
    * 所以有可能某个数组没有第 K/2 个数字，所以需要先 check 一下，数组中到底存不存在第 K/2 个数字，如果存在就取出来，
    * 否则就赋值上一个整型最大值（目的是要在 nums1 或者 nums2 中先淘汰 K/2 个较小的数字，
    * 判断的依据就是看 midVal1 和 midVal2 谁更小，但如果某个数组的个数都不到 K/2 个，自然无法淘汰，
    * 所以将其对应的 midVal 值设为整型最大值，以保证其不会被淘汰），若某个数组没有第 K/2 个数字，
    * 则淘汰另一个数组的前 K/2 个数字即可。举个例子来说吧，比如 nums1 = {3}，nums2 = {2, 4, 5, 6, 7}，K=4，
    * 要找两个数组混合中第4个数字，则分别在 nums1 和 nums2 中找第2个数字，而 nums1 中只有一个数字，不存在第二个数字，
    * 则 nums2 中的前2个数字可以直接跳过，为啥呢，因为要求的是整个混合数组的第4个数字，不管 nums1 中的那个数字是大是小，
    * 第4个数字绝不会出现在 nums2 的前两个数字中，所以可以直接跳过。
    * 有没有可能两个数组都不存在第 K/2 个数字呢，这道题里是不可能的，因为K不是任意给的，而是给的 m+n 的中间值，
    * 所以必定至少会有一个数组是存在第 K/2 个数字的。最后就是二分法的核心啦，比较这两个数组的第 K/2 小的数字 midVal1
    * 和 midVal2 的大小，如果第一个数组的第 K/2 个数字小的话，那么说明要找的数字肯定不在 nums1 中的前 K/2 个数字，
    * 可以将其淘汰，将 nums1 的起始位置向后移动 K/2 个，并且此时的K也自减去 K/2，调用递归，举个例子来说吧，
    * 比如 nums1 = {1, 3}，nums2 = {2, 4, 5}，K=4，要找两个数组混合中第4个数字，那么分别在 nums1 和 nums2
    * 中找第2个数字，nums1 中的第2个数字是3，nums2 中的第2个数字是4，由于3小于4，所以混合数组中第4个数字肯定在
    * nums2 中，可以将 nums1 的起始位置向后移动 K/2 个。反之，淘汰 nums2 中的前 K/2 个数字，并将 nums2
    * 的起始位置向后移动 K/2 个，并且此时的K也自减去 K/2，调用递归即可，参见代码如下：
    *
    * */
    public static double findMedianSortedArraysFive(int[] nums1 , int[] nums2) {

        int m = nums1.length , n = nums2.length , left = (m + n + 1) / 2 , right = (m + n + 2) / 2 ;

        return (findKth(nums1 , 0 , nums2 , 0 , left) + findKth(nums1 , 0 , nums2 , 0 , right)) / 2.0;
    }

    public static int findKth(int[] nums1 , int i , int[] nums2 , int j , int k){
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k -1 ];
        if (k == 1) return Math.min(nums1[i] , nums2[j]);
        int midVal1 = (i + k/2 - 1 <nums1.length) ? nums1[i + k/2 - 1]:Integer.MAX_VALUE;
        int midVal2 = (j + k/2 -1 < nums2.length) ? nums2[j + k/2 - 1]:Integer.MAX_VALUE;
        if (midVal1 < midVal2){
            return findKth(nums1 , i + k/2 , nums2 , j , k - k/2);
        }else {
            return findKth(nums1 , i , nums2 , j + k / 2 , k - k/2);
        }
    }






    /*
    * https://www.cnblogs.com/grandyang/p/4465932.html
    *
    * s6:
    *上面的解法一直使用的是原数组，同时用了两个变量来分别标记当前的起始位置。我们也可以直接生成新的数组，这样就不要用起始位置变量了，不过拷贝数组的操作可能会增加时间复杂度，也许会超出限制，不过就算当个思路拓展也是极好的。首先要判断数组是否为空，为空的话，直接在另一个数组找第K个即可。还有一种情况是当 K = 1 时，表示要找第一个元素，只要比较两个数组的第一个元素，返回较小的那个即可。这里分别取出两个数组的第 K/2 个数字的位置坐标i和j，为了避免数组没有第 K/2 个数组的情况，每次都和数组长度做比较，取出较小值。这里跟上面的解法有些许不同，上面解法直接取出的是值，而这里取出的是位置坐标，但是思想都是很类似的。不同在于，上面解法中每次固定淘汰 K/2 个数字，而这里由于取出了合法的i和j，所以每次淘汰i或j个。评论区有网友提出，可以让 j = k-i，这样也是对的，可能还更好一些，收敛速度可能会更快一些，参见代码如下：
    *
    * */
    public double findMedianSortedArraysSixth(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
    }
    int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        if (m == 0) return nums2[k - 1];
        if (n == 0) return nums1[k - 1];
        if (k == 1) return Math.min(nums1[0], nums2[0]);
        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        if (nums1[i - 1] > nums2[j - 1]) {
            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
        } else {
            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
        }
    }


    /*
    *
    *此题还能用迭代形式的二分搜索法来解，是一种相当巧妙的应用，这里就参照 stellari 大神的帖子 来讲解吧。所谓的中位数，换一种角度去看，其实就是把一个有序数组分为长度相等的两段，中位数就是前半段的最大值和后半段的最小值的平均数，也就是离分割点相邻的两个数字的平均值。比如说对于偶数个数组 [1 3 5 7]，那么分割开来就是 [1 3 / 5 7]，其中 '/' 表示分割点，中位数就是3和5的平均值。对于奇数个数组 [1 3 4 5 7]，可以分割为 [1 3 4 / 4 5 7]，可以发现左右两边都有个4，则中位数是两个4的平均数，还是4。这里使用L表示分割点左边的数字，R表示分割点右边的数字，则对于 [1 3 5 7] 来说，L=3，R=5。对于 [1 3 4 5 7] 来说，L=4，R=4。那么对于长度为N的数组来说，可以分别得到L和R的位置，如下所示：
        复制代码
        N        Index of L        Index of R
        1            0                0
        2            0                1
        3            1                1
        4            1                2
        5            2                2
        6            2                3
        7            3                3
        8            3                4
        复制代码
        观察上表，可以得到规律，Idx(L)= (N-1)/2，idx(R) = N/2，所以中位数可以用下式表示：
        (L + R) / 2 = (A[(N - 1) / 2] + A[N / 2]) / 2
        为了统一数组长度为奇数和偶数的情况，可以使用一个小 tricky，即在每个数字的两边都加上一个特殊字符，比如井号，这个 tricky 其实在马拉车算法中也使用过，可以参见博主之前的帖子 Manacher's Algorithm 马拉车算法。这样做的好处是不管奇数或者偶数，加井号后数组的长度都是奇数，并且切割点的位置也是确定的，比如：
        [1 3 5 7]    ->    [# 1 # 3 # 5 # 7 #]        N = 4
        index               0 1 2 3 4 5 6 7 8         newN = 9
        [1 3 4 5 7]    ->    [# 1 # 3 # 4 # 5 # 7 #]        N = 5
        index                 0 1 2 3 4 5 6 7 8 9 10        newN = 11
        这里的N是原数组的长度，newN 是添加井号后新数组的长度，可以发现 newN = 2N+1，而且切割点永远都在新数组中坐标为N的位置，且 idx(L) = (N-1)/2，idx(R) = N/2，这里的N就可以换成分割点的位置，岂不美哉（注意这里的 idx(L) 和 idx(R) 表示的是在未填充#号的坐标位置）！现在假设有两个数组：
        [1 3 4 5 7]    ->    [# 1 # 3 # 4 # 5 # 7 #]        N1 = 5
        index                 0 1 2 3 4 5 6 7 8 9 10        newN1 = 11
        [1 2 2 2]    ->    [# 1 # 2 # 2 # 2 #]        N2 = 4
        index               0 1 2 3 4 5 6 7 8         newN2 = 9
        跟只有一个数组的情况类似，这里需要找到一个切割点，使得其分别可以将两个数组分成左右两部分，需要满足的是两个左半边中的任意一个数字都要小于两个右半边数组的数字，注意这里可能有的左半边或右半边会为空，但是两个左半边数字的个数和应该等于两个右半边的个数和。这里还可以观察出一些规律：
        1. 总共有 2N1 + 2N2 + 2 个位置，那么除去两个分割点，两个左右半边应该各有 N1 + N2 个数字。
        2. 因此，对于一个在 A2 数组中的分割点位置 C2 = K，在 A1 数组中的位置应该为 C1 = N1 + N2 - K，比如假如在 A2 中的分割点位置为 C2 = 2，那么在 A1 中的位置为 C1 = 4 + 5 - C2 = 7。
        [# 1 # 3 # 4 # (5/5) # 7 #]
        [# 1 / 2 # 2 # 2 #]
        3. 假如两个数组都被分割了，那么就应该会有两个L和R，分别是：
        L1 = A1[(C1 - 1) / 2]
        R1 = A1[C1 / 2]
        L2 = A2[(C2 - 1) / 2]
        R2 = A2[C2 / 2]
        对于上面的例子就有：
        L1 = A1[(7 - 1) / 2] = A1[3] = 5
        R1 = A1[7 / 2] = A1[3] = 5
        L2 = A2[(2 - 1) / 2] = A2[0] = 1
        R2 = A2[2 / 2] = A2[1] = 2
        现在需要检测这个切割点是否是正确的中位数的切割点，那么根据之前的分析，任意的左半边的数字都需要小于等于右半边的数字，L1 和 L2 是左半边的最大的数字，R1 和 R2 是右半边的最小的数字，所以需要满足下列关系：
        L1 <= R1 && L1 <= R2 && L2 <= R1 && L2 <= R2
        由于两个数组都是有序的，所以 L1 <= R1 和 L2 <= R2 都是满足的，那么就只需要满足下列的不等式即可：
        L1 <= R2 && L2 <= R1
        这样的话就可以利用二分搜索了，假如 L1 > R2 的话，说明数组 A1 的左半边的数字过大了，需要把切割点 C1 往左移动。假如 L2 > R1，说明数组 A2 的左半边数字过大，需要把分割点 C2 左移。若满足上面的条件，说明当前切割点就是正确的，那么中位数就可以求出来了，即为：
        (max(L1, L2) + min(R1, R2)) / 2
        最后还有两点注意事项：
        1. 由于 C1 和 C2 是可以互相计算而得，即一个确定了，另一个就可以计算出来了。所以尽量去移动较短的那个数组，这样得到的时间复杂度为 O(lg(min(N1, N2)))。
        2. 对于 corner case 的处理，当切割点在 0 或者 2n 的位置时，将L或R的值分别赋值为整型最小值和最大值，这不会改变正确的切割点的位置，会使得代码实现更加方便。
    *
    * */
    /*
    * 代码量这么少，这个解法很牛叉。
    *
    *
    * */
    public double findMedianSortedArraysSeventh(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m < n) return findMedianSortedArraysSeventh(nums2, nums1);
        if (n == 0) return (nums1[(m - 1) / 2] + nums1[m / 2]) / 2.0;
        int left = 0, right = 2 * n;
        while (left <= right) {
            int mid2 = (left + right) / 2;
            int mid1 = m + n - mid2;
            double L1 = mid1 == 0 ? Double.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = mid2 == 0 ? Double.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = mid1 == m * 2 ? Double.MAX_VALUE : nums1[mid1 / 2];
            double R2 = mid2 == n * 2 ? Double.MAX_VALUE : nums2[mid2 / 2];
            if (L1 > R2) left = mid2 + 1;
            else if (L2 > R1) right = mid2 - 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }


}
