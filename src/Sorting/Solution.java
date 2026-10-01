class Solution {

    /*
        STORY OF MERGE SORT

        We have one big messy group.

        Example:

        [34, 12, 45, 89]

        Instead of sorting everything at once,
        we divide the group into smaller groups.

        Big Group
           |
           +---- Left Group
           |
           +---- Right Group

        We keep doing this until a group contains
        only ONE element.

        One element is already sorted.
    */
    public void mergeSort(int[] numbers, int groupStart, int groupEnd) {
        /*
            STEP 1:
            STOP DIVIDING

            If there is only one element,
            there is nothing left to sort.

            Example:

            [34]

            This is already sorted.
        */
        if (groupStart >= groupEnd) {
            return;
        }

        /*
            STEP 2:
            FIND WHERE THE GROUP WILL SPLIT

            Example:

            [34, 12, 45, 89]

                    split

            [34, 12 | 45, 89]
        */
        int splitPoint = groupStart + (groupEnd - groupStart) / 2;

        /*
            STEP 3:
            FIRST SORT THE LEFT GROUP

            [34, 12 | 45, 89]
             --------
             LEFT GROUP
        */
        mergeSort(numbers, groupStart, splitPoint);

        /*
            STEP 4:
            THEN SORT THE RIGHT GROUP

            [34, 12 | 45, 89]
                      --------
                      RIGHT GROUP
        */
        mergeSort(numbers, splitPoint + 1, groupEnd);

        /*
            STEP 5:
            Now both groups are sorted.

            We can safely combine them.

            Left Group  +  Right Group
                   |
                   v
            One Sorted Group
        */
        joinSortedGroups(numbers, groupStart, splitPoint, groupEnd);
    }

    /*
        ==================================================

        THE JOINING STORY

        We have two already sorted groups.

        Example:

        Left Group:
        [2, 5, 8]

        Right Group:
        [3, 6, 9]

        We need to create:

        [2, 3, 5, 6, 8, 9]

        So we create an empty waiting area.

        [_, _, _, _, _, _]
    */
    public void joinSortedGroups(
        int[] numbers,
        int groupStart,
        int splitPoint,
        int groupEnd
    ) {
        /*
            THE WAITING AREA

            This is where we temporarily build
            the newly sorted group.
        */
        int[] sortedGroup = new int[groupEnd - groupStart + 1];

        /*
            We have TWO groups.

            One person looks at the first element
            of the LEFT group.

            Another person looks at the first element
            of the RIGHT group.
        */
        int lookingAtLeft = groupStart;

        int lookingAtRight = splitPoint + 1;

        /*
            This tells us:

            "Where should the next smallest element
             be placed in the new sorted group?"
        */
        int nextEmptyPlace = 0;

        /*
            ==================================================

            MAIN STORY:

            As long as BOTH groups still have elements:

            Compare the first available element
            from both groups.

            Put the smaller one into the waiting area.
        */
        while (lookingAtLeft <= splitPoint && lookingAtRight <= groupEnd) {
            /*
                Compare:

                LEFT ELEMENT
                        vs
                RIGHT ELEMENT
            */
            if (numbers[lookingAtLeft] <= numbers[lookingAtRight]) {
                /*
                    LEFT ELEMENT IS SMALLER

                    So put it into the next
                    empty position.
                */
                sortedGroup[nextEmptyPlace] = numbers[lookingAtLeft];

                /*
                    Now move forward in the LEFT group.
                */
                lookingAtLeft++;
            } else {
                /*
                    RIGHT ELEMENT IS SMALLER

                    So put it into the next
                    empty position.
                */
                sortedGroup[nextEmptyPlace] = numbers[lookingAtRight];

                /*
                    Now move forward in the RIGHT group.
                */
                lookingAtRight++;
            }

            /*
                One position has now been filled.

                Move to the next empty place.
            */
            nextEmptyPlace++;
        }

        /*
            ==================================================

            POSSIBLE SITUATION:

            One group becomes empty first.

            Example:

            Left:
            [2, 5, 8]

            Right:
            [3, 6]

            After comparison:

            [2, 3, 5, 6]

            Right group is finished.

            What remains?

            [8]

            We simply copy it.

            WHY?

            Because the LEFT group was already sorted.
        */
        while (lookingAtLeft <= splitPoint) {
            sortedGroup[nextEmptyPlace] = numbers[lookingAtLeft];

            lookingAtLeft++;

            nextEmptyPlace++;
        }

        /*
            Same story for the RIGHT group.

            If LEFT finishes first,
            copy everything remaining from RIGHT.

            WHY?

            The RIGHT group is already sorted.
        */
        while (lookingAtRight <= groupEnd) {
            sortedGroup[nextEmptyPlace] = numbers[lookingAtRight];

            lookingAtRight++;

            nextEmptyPlace++;
        }

        /*
            ==================================================

            FINAL STEP

            The waiting area now contains the
            completely sorted group.

            Example:

            sortedGroup:

            [2, 3, 5, 6, 8, 9]


            We now put it back into its original
            position.
        */
        for (
            int placeInSortedGroup = 0;
            placeInSortedGroup < sortedGroup.length;
            placeInSortedGroup++
        ) {
            numbers[groupStart + placeInSortedGroup] = sortedGroup[
                placeInSortedGroup
            ];
        }
    }
}
