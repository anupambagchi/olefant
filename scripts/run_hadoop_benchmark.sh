hadoop jar /usr/lib/hadoop-0.20-mapreduce/hadoop-test.jar TestDFSIO -write -nrFiles 5 -fileSize 100
hadoop jar /usr/lib/hadoop-0.20-mapreduce/hadoop-test.jar TestDFSIO -read -nrFiles 5 -fileSize 100
hadoop jar /usr/lib/hadoop-0.20-mapreduce/hadoop-test.jar TestDFSIO -clean
