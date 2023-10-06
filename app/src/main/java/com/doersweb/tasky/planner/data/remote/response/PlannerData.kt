package com.doersweb.tasky.planner.data.remote.response

import com.doersweb.tasky.planner.data.util.PlannerType

data class PlannerData(
    val plannerType: PlannerType,
    val otherData: String
)
