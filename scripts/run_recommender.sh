WORKDIR=$HOME/Developer/olefant

CLASSNAME=com.agilesoft.recommender.RecommenderIntro

JVM="-Xmn100M -Xms500M -Xmx500M"
source $WORKDIR/scripts/setclasspath.sh
java $JVM -classpath $CLASSPATH $CLASSNAME $1 $2 $3 $4