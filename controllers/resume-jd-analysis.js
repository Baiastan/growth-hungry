import { analyzeJobDecription, validateJobDescription } from "../resume-utils/job-description.js";

export const getResumeJdAnalysis = async (req, res) => {
  try {
    const { data } = req.body;

    const { isValidJd, uniqueWords, message } = validateJobDescription(data);

    if (!isValidJd) {
      res.json({ error: message, status: "ERROR" });
      return;
    }

    const { jobSkills, matchedSkills, error } = analyzeJobDecription(uniqueWords);

    if (error) {
      res.json({ error, status: "ERROR" });
      return;
    }

    res.json({ data: { jobSkills, matchedSkills }, status: "SUCCESS" });
  } catch (error) {
    console.error("Error processing request:", error);
    res.status(500).json({ error: "internal server error. Please try again later" });
  }
};
