max=10
for i in `seq 0 $max`
do
	cp npc$i/row-1-col-1.png npc$i/down_1.png
	cp npc$i/row-1-col-2.png npc$i/down_2.png
	cp npc$i/row-1-col-3.png npc$i/down_3.png
	cp npc$i/row-2-col-1.png npc$i/left_1.png
	cp npc$i/row-2-col-2.png npc$i/left_2.png
	cp npc$i/row-2-col-3.png npc$i/left_3.png
	cp npc$i/row-3-col-1.png npc$i/right_1.png
	cp npc$i/row-3-col-2.png npc$i/right_2.png
	cp npc$i/row-3-col-3.png npc$i/right_3.png
	cp npc$i/row-4-col-1.png npc$i/up_1.png
	cp npc$i/row-4-col-2.png npc$i/up_2.png
	cp npc$i/row-4-col-3.png npc$i/up_3.png
done
