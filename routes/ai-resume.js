import express from "express";
import { getAIResponseOnJD } from "../controllers/ai-resume.js";

import rateLimit from "express-rate-limit";

const limiter = rateLimit({
  windowMs: 24 * 60 * 60 * 1000, // 24 hours
  max: 10,
  message: "You have exceeded the 10 requests in 24 hrs limit!",
  headers: true,
});

const router = express.Router();

router.post("/ai/resume-jd", limiter, getAIResponseOnJD);

export default router;
