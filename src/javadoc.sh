# Generate javadoc for Utilities.
dir=$(dirname $0)
javadoc -noqualifier all \
  -linksource -sourcepath $dir/Utilities \
  -d $dir/../doc/Utilities -link https://docs.oracle.com/javase/8/docs/api/ \
  -windowtitle "2022 CSTA Unit Testing Workshop" \
  -header "<p>2022 CSTA <a href=\"https://bit.ly/2022-csta-unit-testing-workshop\" target=\"_blank\">Unit Testing Workshop</a>" \
  -footer "<p><a href=\"http://j.mp/psb_david_petty\" target=\"_blank\">David C. Petty</a>" \
  $dir/Utilities/Format.java $dir/Utilities/Feedback.java
